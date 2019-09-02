package com.zl.common.sign;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zl
 * @Version 1.0
 * @Description TODO
 * @date 2019/07/01  15:24
 */
public class ZMD5 {
    private static final char[] DIGITS_LOWER = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public ZMD5() {
    }

    public static String digest(byte[] data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(data);
            byte[] messageDigest = digest.digest();
            return toHexString(messageDigest);
        } catch (NoSuchAlgorithmException var3) {
            return "";
        }
    }

    public static String digest(String data) {
        return digest(data.getBytes());
    }

    public static String encodeDigest(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(data.getBytes());
            byte[] messageDigest = digest.digest();
            return new String(encodeHex(messageDigest, true));
        } catch (NoSuchAlgorithmException var3) {
            return "";
        }
    }

    public static String encodeHex(byte[] data, boolean toLowerCase) {
        return new String(encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER));
    }

    protected static char[] encodeHex(byte[] data, char[] toDigits) {
        int l = data.length;
        char[] out = new char[l << 1];
        int i = 0;

        for (int var5 = 0; i < l; ++i) {
            out[var5++] = toDigits[(240 & data[i]) >>> 4];
            out[var5++] = toDigits[15 & data[i]];
        }

        return out;
    }

    public static final String toHexString(byte[] in) {
        int len = in.length;
        StringBuilder sb = new StringBuilder(len * 2);

        for (int i = 0; i < len; ++i) {
            String tmp = Integer.toHexString(in[i] & 255);
            if (tmp.length() < 2) {
                sb.append(0);
            }

            sb.append(tmp);
        }

        return sb.toString();
    }
}
