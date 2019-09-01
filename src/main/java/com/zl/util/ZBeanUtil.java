package com.zl.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zl
 * @Version 1.0
 * @Description TODO
 * @date 2019/07/19  09:18
 */
public class ZBeanUtil {

    /**
     * @param source
     * @return
     * @Title: getNullPropertyNames
     * @Description: 获取一个对象中属性值为null的属性名字符串数组
     */
    public static String[] getNullPropertyNames(Object source) {
        BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (null == srcValue) { emptyNames.add(pd.getName()); }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
