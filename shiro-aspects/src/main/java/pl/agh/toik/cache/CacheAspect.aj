package pl.agh.toik.cache;


import pl.agh.toik.cache.store.CacheContext;
import pl.agh.toik.cache.store.CacheManager;
import pl.agh.toik.cache.store.ResultCache;

public aspect CacheAspect {
    pointcut cached(): @annotation(Cached) && execution(* *(..));
    pointcut cache(): @annotation(Cache) && execution(* *(..));
    pointcut cacheFlush(): @annotation(CacheFlush) && execution(* *(..));

    Object around(): cached() {
        CacheManager cacheManager = CacheContext.getCacheManager();
        String id = CacheUtils.getMethodId(thisJoinPoint);
        ResultCache cache = cacheManager.getCache(id);
        if (!cache.isPresent()) {
            Object o = proceed();
            cache.setCachedValue(o);
            return o;
        } else {
            return cache.getCachedValue();
        }
    }

    Object around(): cache() {
        CacheManager cacheManager = CacheContext.getCacheManager();
        String id = CacheUtils.getCacheAnnotation(thisJoinPoint).name();
        ResultCache cache = cacheManager.getCache(id);
        if (!cache.isPresent()) {
            Object o = proceed();
            cache.setCachedValue(o);
            return o;
        } else {
            return cache.getCachedValue();
        }
    }

    before(): cacheFlush() {
        CacheManager cacheManager = CacheContext.getCacheManager();
        String id = CacheUtils.getCacheFlushAnnotation(thisJoinPoint).name();
        ResultCache cache = cacheManager.getCache(id);
        cache.flushCash();
    }
}
