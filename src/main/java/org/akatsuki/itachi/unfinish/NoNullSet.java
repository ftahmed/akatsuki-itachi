package org.akatsuki.itachi.unfinish;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by long.yl on 2016/7/5.
 */
public class NoNullSet {

    private Set<Object> set;

    public NoNullSet(){
        set = new HashSet<>();
    }

    public boolean add(Object o) {
        if (o != null){
            return set.add(o);
        }
        return false;
    }

    public int size(){
        return set.size();
    }
}
