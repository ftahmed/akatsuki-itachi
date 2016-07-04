package org.akatsuki.itachi.util;

/**
 * Created by long.yl on 2016/7/4.
 */
public class AopMethodImpl implements AopMethod {
    @Override
    public void doBefore(String type) {
        DBContextHolder.setDbType(type);
    }
}
