package com.zl.common.bean;

import java.io.Serializable;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  15:17
 */
public class DataIndex implements Serializable {
    private static final long serialVersionUID = -8236692012443154460L;
    private Integer limit;
    private Integer nextIndex;
    private Integer total;
    private Boolean next;

    public DataIndex() {
    }

    public DataIndex(Integer limit, Integer nextIndex) {
        this.limit = limit;
        this.nextIndex = nextIndex;
    }

    public DataIndex(Integer limit, Integer nextIndex, Boolean next) {
        this.limit = limit;
        this.nextIndex = nextIndex;
        this.next = next;
    }

    public static DataIndex getResultIndex(Integer limit, Integer nextIndex) {
        if (nextIndex > 0) {
            return new DataIndex(limit, nextIndex, true);
        } else {
            return new DataIndex(limit, nextIndex, false);
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getNextIndex() {
        return nextIndex;
    }

    public void setNextIndex(Integer nextIndex) {
        this.nextIndex = nextIndex;
    }

    public Boolean getNext() {
        if (null == next) {
            if (nextIndex > 0) {
                return true;
            } else {
                return false;
            }
        }
        return next;
    }

    public void setNext(Boolean next) {
        this.next = next;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DataIndex{" +
            "limit=" + limit +
            ", nextIndex=" + nextIndex +
            ", total=" + total +
            ", next=" + next +
            '}';
    }
}