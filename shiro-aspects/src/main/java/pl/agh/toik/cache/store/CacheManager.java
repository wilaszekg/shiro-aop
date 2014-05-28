package pl.agh.toik.cache.store;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {
    private Map<String, ResultCache> caches = new HashMap<>();

    public synchronized ResultCache getCache(String id) {
        if (!caches.containsKey(id)) {
            caches.put(id, new ResultCache());
        }
        return caches.get(id);
    }
}
