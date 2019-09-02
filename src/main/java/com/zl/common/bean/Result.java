package com.zl.common.bean;

import java.io.Serializable;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  15:19
 */
public class Result implements Serializable {
    private static final long serialVersionUID = -2223533973355034183L;
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";
    private int code;
    private String msg;
    private Object result;

    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public static Result getSuccess() {
        return new Result(0, SUCCESS);
    }

    public static Result getSuccess(Object result) {
        return new Result(0, SUCCESS, result);
    }

    public static Result getError(int code) {
        return new Result(code, ERROR);
    }

    public static Result getError(int code, String msg) {
        return new Result(code, msg);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getResult() {
        return result;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result setResult(Object result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
            "code=" + code +
            ", msg='" + msg + '\'' +
            ", result=" + result +
            '}';
    }
}
