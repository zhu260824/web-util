package com.zl.common.bean;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  15:20
 */
public class ResultIndex extends Result {
    private DataIndex page;

    public ResultIndex() {
    }

    public ResultIndex(int code, String msg) {
        super(code, msg);
    }

    public ResultIndex(int code, String msg, Object result) {
        super(code, msg, result);
    }

    public ResultIndex(int code, String msg, Object result, DataIndex page) {
        super(code, msg, result);
        this.page = page;
    }

    public static ResultIndex getSuccess() {
        return new ResultIndex(0, SUCCESS);
    }

    public static ResultIndex getSuccess(Object result) {
        return new ResultIndex(0, SUCCESS, result);
    }

    public static ResultIndex getSuccess(Object result, DataIndex page) {
        return new ResultIndex(0, SUCCESS, result, page);
    }

    public static ResultIndex getSuccess(Object result, Integer index, Integer limit, Integer size) {
        DataIndex dataIndex = new DataIndex();
        dataIndex.setLimit(limit);
        if (size < limit) {
            dataIndex.setNextIndex(-1);
            dataIndex.setNext(false);
        } else {
            dataIndex.setNext(true);
            dataIndex.setNextIndex(index + limit);
        }
        return new ResultIndex(0, SUCCESS, result, dataIndex);
    }

    public static ResultIndex getError(int code) {
        return new ResultIndex(code, ERROR);
    }

    public static ResultIndex getError(int code, String msg) {
        return new ResultIndex(code, msg);
    }

    public DataIndex getPage() {
        return page;
    }

    public void setPage(DataIndex page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "ResultIndex{" +
            "page=" + page +
            '}';
    }
}

