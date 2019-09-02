package com.zl.common.exception;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  15:31
 */
public enum BusinessEnums {
    DATA_STATUS_ERROR(9989, "状态错误"),
    UP_DATA_IN_WORK(9990, "提交的数据正在处理中"),
    START_TIME_AFTER_END_TIME(9991, "开始时间必须必结束时间小"),
    FILE_READ_FAIL(9992, "文件读取失败"),
    CREATE_IS_ERROR(9993, "新增失败"),
    DELETE_IS_ERROR(9994, "删除失败"),
    UPDATE_IS_ERROR(9995, "更新失败"),
    QUERY_IS_ERROR(9996, "查找失败"),
    PARAMETER_IS_NULL(9997, "参数为空"),
    PARAMETER_IS_ERROR(9998, "参数错误"),
    NETWORK_IS_ERROR(9999, "网络错误"),
    ;

    private int code;
    private String desc;

    BusinessEnums(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BusinessException throwException() {
        return new BusinessException(code, desc);
    }

    @Override
    public String toString() {
        return "BusinessEnums{" +
            "code=" + code +
            ", desc='" + desc + '\'' +
            '}';
    }
}
