package com.zl.util.http;

/**
 * @author zl
 * @Version 1.0
 * @Description TODO
 * @date 2019/01/16  14:51
 */
public interface HttpCallBack <T> {
    void onSuccess(T data);

    void onException(Exception e);
}
