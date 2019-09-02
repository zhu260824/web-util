package com.zl.common.converter;

import com.zl.common.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zl
 * @Version 1.0
 * @Description TODO
 * @date 2019/01/15  13:29
 */
public class UnderLineToCamel {
    /**
     * 驼峰转下划线
     */
    public static String camelTounderLine(String param) {
        if (StringUtil.isEmpty(param)) {return param;}
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i > 0) {
                    sb.append('_');
                }
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 下划线转驼峰
     */
    public static String underLineToCamel(String param) {
        if (StringUtil.isEmpty(param)) { return param;}
        List<String> oldKeyList = StringUtil.stringToSList(param, "_");
        if (oldKeyList == null || oldKeyList.isEmpty()) { return param;}
        List<String> operable = new ArrayList<>(oldKeyList);
        StringBuilder sb = new StringBuilder();
        sb.append(operable.get(0));
        operable.remove(0);
        if (!operable.isEmpty()) {
            for (String key : operable) {
                char[] cs = key.toCharArray();
                if (Character.isLowerCase(cs[0])) {
                    cs[0] -= 32;
                }
                sb.append(String.valueOf(cs));
            }
        }
        return sb.toString();
    }
}
