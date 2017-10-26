package com.shankes.account.captcha;

import java.util.Random;

/**
 * 生成随机验证码对应key
 */
public class RandomGenerator {

    private static final String range = "0123456789abcdefghijklmnopqrstuvwxyz";// 随机验证码对应key取值范围
    private static final int rangeLength = 8;// 随机验证码对应key长度

    public static synchronized String getRandomString() {
        Random random = new Random();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < rangeLength; i++) {
            result.append(range.charAt(random.nextInt(range.length())));
        }
        return result.toString();
    }
}
