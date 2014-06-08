package pl.agh.toik.cache.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheManager {
    private Map<Identity, ResultCache> caches = new HashMap<Identity, ResultCache>();

    public synchronized ResultCache getCache(String id) {
    	Identity identity = new Identity(id);
        return getCacheInner(identity);
    }
    
    public synchronized ResultCache getCache(String id, List<String> params){
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
	private List<String> params;
	
	public Identity(String id){
		this.id = id;
		params = new ArrayList<>();
	}
	
	public Identity(String id, List<String> params){
		this.id = id;
		this.params = params;
	}
	
	@Override
	public boolean equals(Object other){
		if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Identity))return false;
	    
	    Identity otherId = (Identity)other;
	    if(id.equals(otherId.id) && params.size() == otherId.params.size() && params.containsAll(otherId.params))
	    	return true;
	    return false;
	}
	
	@Override
	public int hashCode(){
		return 0;
	}
}