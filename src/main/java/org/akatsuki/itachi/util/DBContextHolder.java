package org.akatsuki.itachi.util;

/**
 * Created by long.yl on 2016/7/4.
 */
public class DBContextHolder {

    /**
     * 线程threadlocal
     */
    private static ThreadLocal<String> contextHolder = new ThreadLocal<>();

    private static final String MASTER = "master";
    private static final String SLAVER = "slaver";

    public static String getDbType() {
        String db = contextHolder.get();
        if (db == null) {
            System.out.println("该请求线程没有设置，返回默认主库数据 ... ");
            db = MASTER;// 默认是主库
        }
        System.out.println("该请求数据源被路由为 : " + db);
        return db;
    }

    /**
     *
     * 设置本线程的dbtype
     *
     * @param str
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void setDbType(String str) {
        contextHolder.set(str);
    }

    public static void setDBMaster(){
        System.out.println("设置该线程的数据源为主库 ... ");
        contextHolder.set(MASTER);
    }

    public static void setDBSlaver(){
        System.out.println("设置该线程的数据源为从库 ... ");
        contextHolder.set(SLAVER);
    }

    /**
     * clearDBType
     *
     * @Title: clearDBType
     * @Description: 清理连接类型
     */
    public static void clearDBType() {
        contextHolder.remove();
    }

}
