package org.akatsuki.itachi.unfinish;

/**
 * Created by long.yl on 2016/7/4.
 */
public class MultiDataSourceConfigurationException extends RuntimeException {
    @Override
    public String getMessage() {
        return "only one datasource can be configured in by annotation";
    }
}
