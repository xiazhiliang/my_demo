package com.example.tests;

import com.example.file.FileType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author baidu
 * @date 2018/4/24 下午4:45
 * @description 文件上传漏洞，通过魔数实现
 **/
public class FileTypeTest {
    /**
     * 判断文件类型
     *
     * @param filePath 文件路径
     * @return 文件类型
     */
    public static FileType getType(String filePath) throws IOException {

        String fileHead = getFieHeader(filePath);

        if (fileHead == null || fileHead.length() == 0) {
            return null;
        }

        fileHead = fileHead.toUpperCase();

        FileType[] fileTypes = FileType.values();

        for (FileType type : fileTypes) {
            if (fileHead.startsWith(type.getValue())) {
                return type;
            }
        }

        return null;
    }

    private static String getFieHeader(String filePath) throws IOException {
        byte[] b = new byte[28];
        InputStream inputStream = new FileInputStream(filePath);
        inputStream.read(b, 0, 28);
        inputStream.close();
        return bytes2hex(b);
    }

    /**
     * 将文件头转换成16进制字符串
     *
     * @param source
     * @return 16进制字符串
     */
    private static String bytes2hex(byte[] source) {

        StringBuilder stringBuilder = new StringBuilder();
        if (source == null || source.length <= 0) {
            return null;
        }
        for (int i = 0; i < source.length; i++) {
            int v = source[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        Integer x = 10;
        String hex = x.toHexString(x);
        System.out.println(hex);
        String content = "0fff";
        System.out.println(Integer.parseInt(content, 16));

        System.out.println(0x10);
//        System.out.println(bytes2hex(String.valueOf(a).getBytes()));
    }
}
