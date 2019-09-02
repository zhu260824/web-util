package com.zl.common.util;


import org.apache.commons.codec.binary.Base64;

/**
 * @author zl
 * @Version 1.0
 * @Description TODO
 * @date 2019/01/18  13:30
 */
public class Base64Util {

    public static String encode(byte[] date){
        return Base64.encodeBase64String(date).trim();
    }

    public static byte[] decode(String base64){
       return   Base64.decodeBase64(base64);
    }
}
