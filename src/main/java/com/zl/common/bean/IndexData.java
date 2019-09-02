package com.zl.common.bean;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  15:18
 */
public class IndexData {
    private Object result;
    private DataIndex dataIndex;

    public IndexData() {
    }

    public IndexData(Object result, DataIndex dataIndex) {
        this.result = result;
        this.dataIndex = dataIndex;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public DataIndex getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(DataIndex dataIndex) {
        this.dataIndex = dataIndex;
    }

    public static IndexData getIndexData(Object result, Integer index, Integer limit, Integer size, Long total) {
        DataIndex dataIndex = getDataIndex(index, limit, size, total);
        return new IndexData(result, dataIndex);
    }

    public static IndexData getIndexData(Object result, Integer index, Integer limit, Integer size, Integer total) {
        DataIndex dataIndex = getDataIndex(index, limit, size, total);
        return new IndexData(result, dataIndex);
    }

    public static DataIndex getDataIndex(Integer index, Integer limit, Integer size, Long total) {
        int indexTotal = 0;
        if (total != null) {
            indexTotal = total.intValue();
        }
        return getDataIndex(index, limit, size, indexTotal);
    }

    public static DataIndex getDataIndex(Integer index, Integer limit, Integer size, Integer total) {
        DataIndex dataIndex = new DataIndex();
        dataIndex.setTotal(total);
        dataIndex.setLimit(limit);
        if (size < limit) {
            dataIndex.setNextIndex(-1);
            dataIndex.setNext(false);
        } else {
            dataIndex.setNext(true);
            dataIndex.setNextIndex(index + limit);
        }
        return dataIndex;
    }

    public static ResultIndex transform(IndexData indexData) {
        return ResultIndex.getSuccess(indexData.getResult(), indexData.getDataIndex());
    }

    @Override
    public String toString() {
        return "IndexData{" +
            "result=" + result +
            ", dataIndex=" + dataIndex +
            '}';
    }
}
