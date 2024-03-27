package org.example.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    /**
     * 将字符串进行MD5加密
     *
     * @param input 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String encrypt(String input) {
        try {
            // 创建一个MessageDigest实例对象，并指定算法为MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 将需要加密的字符串转换为字节数组
            byte[] messageDigest = md.digest(input.getBytes(StandardCharsets.UTF_8));

            // 创建16进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String input = "Hello, World!";
        String md5 = encrypt(input);
        System.out.println("MD5加密后的字符串: " + md5);
    }
}
