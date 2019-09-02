package com.zl.common.converter;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  11:36
 */
public class NumberConverter {

    public static String number2String(Long id) {
        String idStr = id.toString();
        char[] chars = idStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            c += 'a' - '0';
            chars[i] = c;
        }
        return new String(chars);
    }

    public static void main(String[] args){
        String s = number2String(117606L);
        System.out.println(s);
    }
}
