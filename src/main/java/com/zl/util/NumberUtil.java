package com.zl.util;

import java.math.BigDecimal;

public class NumberUtil {
    public static double toFixed(double number, Integer scale) {
        BigDecimal bigDecimal = new BigDecimal(number);
        return bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double toNormal(double number, Integer scale) {
        String str = new BigDecimal(number).toString();
        double num = StringUtil.stringToDouble(str);
        return toFixed(num, scale);
    }
}
