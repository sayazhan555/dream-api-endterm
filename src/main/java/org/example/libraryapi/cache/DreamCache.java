package org.example.libraryapi.cache;

import org.example.libraryapi.model.Dream;

import java.util.*;

public class DreamCache {

    private static DreamCache instance;

    private List<Dream> cachedDreams;

    private DreamCache() {}

    public static synchronized DreamCache getInstance() {
        if (instance == null) {
            instance = new DreamCache();
        }
        return instance;
    }

    //  Cache operations

    public List<Dream> getDreams() {
        return cachedDreams;
    }

    public void putDreams(List<Dream> dreams) {
        this.cachedDreams = dreams;
    }

    public void clear() {
        this.cachedDreams = null;
    }

    public boolean hasCache() {
        return cachedDreams != null;
    }
}
