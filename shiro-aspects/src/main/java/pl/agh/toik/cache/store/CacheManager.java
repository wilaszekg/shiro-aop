package pl.agh.toik.cache.store;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CacheManager {
    private Map<Identity, ResultCache> caches = new HashMap<Identity, ResultCache>();

    public synchronized ResultCache getCache(String id) {
        Identity identity = new Identity(id);
        return getCacheInner(identity);
    }

    public synchronized ResultCache getCache(String id, Object[] params) {
        Identity identity = new Identity(id, params);
        return getCacheInner(identity);
    }

    private ResultCache getCacheInner(Identity identity) {
        if (!caches.containsKey(identity)) {
            caches.put(identity, new ResultCache());
        }
        return caches.get(identity);
    }
}

class Identity {
    private String id;
    private Object[] params;

    public Identity(String id) {
        this.id = id;
        params = new Object[0];
    }

    public Identity(String id, Object[] params) {
        this.id = id;
        this.params = params;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Identity)) return false;

        Identity otherId = (Identity) other;
        if (!id.equals(otherId.id) || params.length != otherId.params.length) {
            return false;
        }
        for (int i = 0; i < params.length; i++) {
            if (!params[i].equals(otherId.params[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Arrays.asList(params));
    }
}