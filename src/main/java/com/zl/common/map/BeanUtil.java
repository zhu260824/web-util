package com.zl.common.map;

import org.springframework.beans.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  14:31
 */
public class BeanUtil {

    public static void transMap2Bean2(Map<String, Object> map, Object obj) {
        if (map == null || obj == null) {
            return;
        }
        try {
            BeanUtils.copyProperties(map, obj);
        } catch (Exception e) {
            System.out.println("transMap2Bean2 Error " + e);
        }
    }

    /**
     * @param map
     * @param obj
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @Desc Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean 强类型转换  慎用
     */
    public static void transMap2Bean(Map<String, Object> map, Object obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (map.containsKey(key)) {
                Object value = map.get(key);
                // 得到property对应的setter方法
                Method setter = property.getWriteMethod();
                setter.invoke(obj, new Object[] {value});
            }
        }
        return;
    }

    /**
     * @param obj
     * @return Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
     */
    public static Map<String, Object> transBean2Map(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    if (null != getter) {
                        Object value = getter.invoke(obj);
                        if (null != value) {
                            map.put(key, value);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("transBean2Map Error " + e);
        }
        return map;
    }

    public static <T> T beanCovert(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        try {
            T target = null;
            target = targetClass.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            System.out.println("对象初始化错误" + e);
        }
        return null;
    }

    public static <T, U> List<U> beanListCovert(List<T> source, Class<U> targetClass) {
        List<U> target = new ArrayList<U>();
        if (source != null && !source.isEmpty()) {
            target = source.stream().map(sourceBean ->
                BeanUtil.beanCovert(sourceBean, targetClass)).collect(Collectors.toList());
        }
        return target;
    }

    public static Boolean persisted(Object beanObject) {
        if (beanObject == null) {
            return false;
        }
        try {
            Method getMethod = beanObject.getClass().getMethod("getId");
            Long id = (Long)getMethod.invoke(beanObject);
            if (id > 0) {
                return true;
            }
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException ignore) {
            ignore.printStackTrace();
        }
        return false;
    }
}
