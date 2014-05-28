package pl.agh.toik.cache.store;

public class ResultCache {
    private Object cachedValue;

    public Object getCachedValue() {
        return cachedValue;
    }

    public void setCachedValue(Object cachedValue) {
        this.cachedValue = cachedValue;
    }

    public boolean isPresent() {
        return cachedValue != null;
    }

    public void flushCash() {
        cachedValue = null;
    }
}
