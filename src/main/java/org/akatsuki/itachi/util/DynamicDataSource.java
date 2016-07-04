package org.akatsuki.itachi.util;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.logging.Logger;

/**
 * Created by long.yl on 2016/7/4.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /*
     * (non-Javadoc)
     * @see javax.sql.CommonDataSource#getParentLogger()
     */
    @Override
    public Logger getParentLogger() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     *
     * override determineCurrentLookupKey
     * <p>
     * Title: determineCurrentLookupKey
     * </p>
     * <p>
     * Description: 自动查找datasource
     * </p>
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.getDbType();
    }

}
