package org.akatsuki.itachi.unfinish.aop;

import org.akatsuki.itachi.util.DBContextHolder;

/**
 * Created by long.yl on 2016/7/4.
 */
public class AopMethodImpl implements AopMethod {
    @Override
    public void doBefore(String type) {
        DBContextHolder.setDbType(type);
    }
}
