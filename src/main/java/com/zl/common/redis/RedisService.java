package com.zl.common.redis;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  15:22
 */
public interface RedisService {
    void set(String key, Object value);

    void set(String key, Object value, long timeout);

    Object get(String key);

    Boolean delete(String key);
}
