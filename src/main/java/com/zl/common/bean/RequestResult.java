package com.zl.common.bean;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  15:19
 */
public class RequestResult <T> {
    private Integer code;
    private String msg;
    private T result;

    public RequestResult() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess(){
        if (code!=null && code.equals(0)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "RequestResult{" +
            "code=" + code +
            ", msg='" + msg + '\'' +
            ", result=" + result +
            '}';
    }
}

