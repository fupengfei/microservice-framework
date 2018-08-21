package com.fpfos.common.core.utils;

import org.apache.commons.codec.binary.Hex;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.util.Random;

/**
 * Created by Fu Pengfei on 2018/8/2.
 */
public class EncryptUtils {

    private static final String SALT_SOURCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!#@$%^&~_-=+|";

    /**
     * 获取十六进制字符串形式的MD5摘要
     *
     * @param salt
     * @param src
     * @return
     */
    public static String generateMd5Hex(String salt, String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            return new String(new Hex().encode(md5.digest((salt.concat(src)).getBytes())));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 校验
     *
     * @param salt
     * @param plain
     * @param md5String
     * @return
     */
    public static boolean verifyMd5Hex(String salt, String plain, String md5String) {
        if (null == salt || salt.isEmpty() || null == plain || plain.isEmpty()) {
            return false;
        }
        return generateMd5Hex(salt, plain).equals(md5String);
    }

    /**
     * 生成16位随机字符串作为盐值
     *
     * @return
     */
    public static String generateSalt() {
        StringBuffer stringBuffer = new StringBuffer("");
        String ori = SALT_SOURCE;
        for (int i = 0; i < 16; i++) {
            String toString = stringBuffer.toString();
            if (StringUtils.isEmpty(toString)) {
                stringBuffer.append(SALT_SOURCE.charAt(new Random().nextInt(SALT_SOURCE.length())));
            } else {
                String strAtIndex = new String(new char[]{toString.charAt(i - 1)});
                if (ori.contains(strAtIndex)) {
                    ori = ori.replace(strAtIndex, "");
                    stringBuffer.append(ori.charAt(new Random().nextInt(ori.length())));
                }
            }
        }
        return stringBuffer.toString();
    }

}
