package com.example.tests;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * @author baidu
 * @date 2018/4/24 下午11:44
 * @description ${TODO}
 **/
public class DESDigest {
    public static void main(String[] args) {

    }

    private static String byte2base64(byte[] bytes) {
        BASE64Encoder base64Decoder = new BASE64Encoder();
        return base64Decoder.encode(bytes);
    }

    private static byte[] base642byte(String base64) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(base64);
    }

    public static String getKeyDES() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();
        String base64String = byte2base64(secretKey.getEncoded());
        return base64String;
    }

    public static SecretKey loadKeyDES(String base64Key) throws IOException {
        byte[] bytes = base642byte(base64Key);
        SecretKey key = new SecretKeySpec(bytes, "DES");
        return key;
    }
}
