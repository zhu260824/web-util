package com.zl.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.List;

/**
 * @author zl
 * @Version 1.0
 * @Description TODO
 * @date 2019/01/15  13:29
 */
public class StringUtil {

    public static boolean isEmpty(String value) {
        if (value != null && value.length() > 0) {
            return false;
        }
        return true;
    }

    public static List<String> stringToSList(String data) {
        return stringToSList(data, ",");
    }

    public static List<String> stringToSList(String data, String regex) {
        if (isEmpty(data) || isEmpty(regex)) {
            return null;
        }
        return new ArrayList<>(Arrays.asList(data.split(regex)));
    }

    public static List<Long> stringToLList(String data) {
        return stringToLList(data, ",");
    }

    public static List<Long> stringToLList(String data, String regex) {
        if (isEmpty(data) || isEmpty(regex)) {
            return null;
        }
        String[] strings = data.split(regex);
        List<Long> list = new ArrayList<>();
        for (String string : strings) {
            Long values = stringToLong(string);
            if (values != null) {
                list.add(values);
            }
        }
        return list;
    }

    public static Integer stringToInteger(String data) {
        Integer value = null;
        try {
            if (!isEmpty(data)) {
                value = Integer.parseInt(data);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static Long stringToLong(String data) {
        Long value = null;
        try {
            if (!isEmpty(data)) {
                value = Long.parseLong(data);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static Double stringToDouble(String data) {
        Double value = null;
        try {
            if (!isEmpty(data)) {
                value = Double.parseDouble(data);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String IntegerToString(Integer data) {
        if (data != null) {
            return String.valueOf(data);
        } else {
            return "";
        }
    }

    public static String doubleToString(Double data) {
        if (data == null) return "";

        return doubleToString(data, "%.2f");
    }

    public static String doubleToString(Double data, String format) {
        String value = null;
        if (data != null) {
            try {
                value = String.format(format, data);
            } catch (IllegalFormatException ex) {
                ex.printStackTrace();
            }
        }
        if (isEmpty(value)) {
            value = "0";
        }
        return value;
    }

}
