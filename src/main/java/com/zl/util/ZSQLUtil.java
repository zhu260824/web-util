package com.zl.util;

/**
 * @author ZL
 * @Version 1.0
 * @Description
 * @date 2019/06/06 22:58
 */
public class ZSQLUtil {
    public static final int DEFAULT_LIMIT = 100;
    public static final int DEFAULT_INDEX = 0;

    public static String getDESC(String field) {
        return field + " DESC";
    }

    public static String getASC(String field) {
        return field + " ASC";
    }

    public static String getLIMIT(int start, int end) {
        return "LIMIT " + start + "," + end;
    }

    public static String getDESCAndLIMIT(String field, Integer start, Integer end) {
        if (null == start || start < 0) {
            start = DEFAULT_INDEX;
        }
        if (null == end || end < 0) {
            end = DEFAULT_LIMIT + start;
        }
        int limit = end - start;
        return field + " DESC " + "LIMIT " + start + "," + limit;
    }

    public static String getASCAndLIMIT(String field, Integer start, Integer end) {
        if (null == start || start < 0) {
            start = DEFAULT_INDEX;
        }
        if (null == end || end < 0) {
            end = DEFAULT_LIMIT + start;
        }
        int limit = end - start;
        return field + " ASC " + "LIMIT " + start + "," + limit;
    }

    public static String getDESCAndLIMITL(String field, Integer start, Integer limit) {
        if (null == start || start < 0) {
            start = DEFAULT_INDEX;
        }
        if (null == limit || limit < 0) {
            limit = DEFAULT_LIMIT;
        }
        return field + " DESC " + "LIMIT " + start + "," + limit;
    }

    public static String getASCAndLIMITL(String field, Integer start, Integer limit) {
        if (null == start || start < 0) {
            start = DEFAULT_INDEX;
        }
        if (null == limit || limit < 0) {
            limit = DEFAULT_LIMIT;
        }
        return field + " ASC " + "LIMIT " + start + "," + limit;
    }
}
