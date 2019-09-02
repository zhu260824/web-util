package com.zl.common.map;

import com.google.common.collect.Maps;
import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  14:34
 */
public class MapUtil {

    /**
     * 过滤掉value为空的Map值
     *
     * @param mapObject
     * @return
     */
    public static Map<String, Object> filterMapNullValue(Map<String, Object> mapObject) {
        if (null == mapObject || mapObject.size() == 0) {
            return mapObject;
        }
        Iterator<Map.Entry<String, Object>> it = mapObject.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            if (null == entry.getValue()) {
                it.remove();
            }
        }
        return mapObject;
    }

    public static Map<String, Object> transBeanToMap(Object obj) {
        if (obj != null) {
            Map<String, Object> map = Maps.newHashMap();
            try {
                BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
                PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                for (PropertyDescriptor property : propertyDescriptors) {
                    String key = property.getName();
                    if (!"class".equals(key)) {
                        Method getter = property.getReadMethod();
                        Object value = getter.invoke(obj);
                        map.put(key, value);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return map;
        }
        return null;
    }

    public static Object transMapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map != null) {
            Object obj = beanClass.newInstance();
            BeanUtils.populate(obj, map);
            return obj;
        }
        return null;
    }
}
