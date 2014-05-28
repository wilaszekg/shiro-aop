package pl.agh.toik.cache.store;

public class CacheContext {
    private static CacheManager cacheManager = new CacheManager();

    public static CacheManager getCacheManager() {
        return cacheManager;
    }

    public static void setCacheManager(CacheManager cacheManager) {
        CacheContext.cacheManager = cacheManager;
    }
}
