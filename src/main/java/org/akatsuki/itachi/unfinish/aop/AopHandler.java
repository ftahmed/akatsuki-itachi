package org.akatsuki.itachi.unfinish.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by long.yl on 2016/7/4.
 */
public class AopHandler implements InvocationHandler {
    //保存对象
    private AopMethod method;
    private Object o;
    private String type;

    public AopHandler(Object o, AopMethod method, String type) {
        this.o = o;
        this.method = method;
        this.type = type;
    }

    /**
     * 这个方法会自动调用,Java动态代理机制
     * 会传入下面是个参数
     * 不能使用invoke时使用proxy作为反射参数时,因为代理对象的接口,不同于对象
     * 这种代理机制是面向接口，而不是面向类的
     **/

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;
        //修改的地方在这里哦
        this.method.doBefore(type);
        ret = method.invoke(o, args);
        return ret;
    }
}
