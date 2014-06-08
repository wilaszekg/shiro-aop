package pl.agh.toik.cache;

import java.util.ArrayList;
import java.util.List;

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
    
    public static CacheWithParams getCacheWithParamsAnnotation(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod().getAnnotation(CacheWithParams.class);
    }
    
    public static CachedWithParams getCachedWithParamsAnnotation(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod().getAnnotation(CachedWithParams.class);
    }
    
    public static List<String> getParametersValues(JoinPoint joinPoint) {
    	Object[] paramValues = joinPoint.getArgs();
    	
    	List<String> params = new ArrayList<>();
    	for (Object param : paramValues) {
			params.add(toString(param));
		}
    	return params;
    }
    
    private static String toString(Object object) {
    	if (object == null)
            return "<null>";
    	else if (object instanceof String) 
            return (String) object;
    	else if (object instanceof Long)
            return ((Long) object).toString();
    	else if (object instanceof Boolean)
            return ((Boolean) object).toString();
    	else if (object instanceof Double)
            return ((Double) object).toString();
    	else if (object instanceof Integer)
            return ((Integer) object).toString();
    	else if (object instanceof List)
            return "items{" + ((List) object).size() + "}";
    	else
            return "object";
    }
}
