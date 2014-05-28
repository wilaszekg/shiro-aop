package pl.agh.toik.samples.cache;

import pl.agh.toik.cache.Cache;
import pl.agh.toik.cache.CacheFlush;
import pl.agh.toik.cache.Cached;

public class Computer {
    private String result = "some result";

    @Cached
    public int compute() {
        System.out.println("Computing in compute method...");
        return 100;
    }

    @Cache(name = "computer.result")
    public String getResult() {
        System.out.println("Computing in getResult method...");
        return result;
    }

    @CacheFlush(name = "computer.result")
    public void setResult(String result) {
        this.result = result;
    }
}
