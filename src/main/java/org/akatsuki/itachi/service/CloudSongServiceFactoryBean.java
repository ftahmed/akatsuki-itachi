package org.akatsuki.itachi.service;

import org.akatsuki.itachi.meta.CloudSong;
import org.akatsuki.itachi.util.*;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by long.yl on 2016/7/4.
 */
@Configuration
public class CloudSongServiceFactoryBean implements FactoryBean<CloudSongService> {

    CloudSongService cloudSongService;

    ReentrantLock lock = new ReentrantLock();

    private CloudSongService getInstance() {
        if (cloudSongService == null) {
            lock.lock();
            try {
                if (cloudSongService == null) {
                    cloudSongService = getProxy(new CloudSongServiceImpl(), new AopMethodImpl());
                }
            } finally {
                lock.unlock();
            }
        }
        return cloudSongService;
    }

    private CloudSongService getProxy(Object obj, AopMethod aopMethod) {
        return (CloudSongService) Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), new AopHandler(obj, aopMethod, parserAnnotation((CloudSongServiceImpl)obj)));
    }

    private String parserAnnotation(CloudSongService cloudSongService){
        Annotation annotation = isMultiDataSourceConfiguration(cloudSongService);
        if (annotation != null) {
            if (annotation instanceof FromSlaver) {
                return "slaver";
            } else if (annotation instanceof FromMaster) {
                return "master";
            } else {
                return ((FromDB)annotation).value();
            }
        }else {
            Method[] methods = cloudSongService.getClass().getDeclaredMethods();
            for (Method method : methods) {
                annotation = isMultiDataSourceConfiguration(method);
                if (annotation != null) {
                    if (annotation instanceof FromSlaver) {
                        return "slaver";
                    } else if (annotation instanceof FromMaster) {
                        return "master";
                    } else {
                        return ((FromDB)annotation).value();
                    }
                }
            }
        }
        return "master";
    }

    private Annotation isMultiDataSourceConfiguration(CloudSongService obj) {
        Set<Annotation> set = new HashSet<>();
        FromSlaver fromSlaver = obj.getClass().getAnnotation(FromSlaver.class);
        FromMaster fromMaster = obj.getClass().getAnnotation(FromMaster.class);
        FromDB fromDB = obj.getClass().getAnnotation(FromDB.class);
        set.add(fromSlaver);
        set.add(fromMaster);
        set.add(fromDB);
        if (set.size() >= 2) {
            throw new MultiDataSourceConfigurationException();
        }
        return fromSlaver != null ? fromSlaver : (fromMaster != null ? fromMaster : fromDB);
    }

    private Annotation isMultiDataSourceConfiguration(Method method) {
        Set<Annotation> set = new HashSet<>();
        FromSlaver fromSlaver = method.getAnnotation(FromSlaver.class);
        FromMaster fromMaster = method.getAnnotation(FromMaster.class);
        FromDB fromDB = method.getAnnotation(FromDB.class);
        set.add(fromSlaver);
        set.add(fromMaster);
        set.add(fromDB);
        if (set.size() >= 2) {
            throw new MultiDataSourceConfigurationException();
        }
        return fromSlaver != null ? fromSlaver : (fromMaster != null ? fromMaster : fromDB);
    }


    @Override
    @Bean
    public CloudSongService getObject() throws Exception {
        return getInstance();
    }

    @Override
    public Class<?> getObjectType() {
        return CloudSong.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
