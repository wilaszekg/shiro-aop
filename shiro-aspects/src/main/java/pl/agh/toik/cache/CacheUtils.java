package pl.agh.toik.cache;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

public class CacheUtils {

    public static String getMethodId(JoinPoint thisJoinPoint) {
        return thisJoinPoint.getSignature().toLongString();
    }

    public static Cache getCacheAnnotation(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod().getAnnotation(Cache.class);
    }

    public static CacheFlush getCacheFlushAnnotation(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod().getAnnotation(CacheFlush.class);
    }
}
