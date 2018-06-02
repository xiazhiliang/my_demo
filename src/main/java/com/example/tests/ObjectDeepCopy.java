package com.example.tests;

import java.io.*;

/**
 * @author baidu
 * @date 2018/4/18 下午9:54
 * @description ${TODO}
 **/
public class ObjectDeepCopy {
    public static <T> T deepCopy(T t) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream objectOutput = new ObjectOutputStream(byteOut);
        objectOutput.writeObject(t);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream objectInput = new ObjectInputStream(inputStream);
        return (T) objectInput.readObject();
    }

    public static void main(String[] args) {
        User user = new User();
        user.setAddress("dazhou");
        user.setName("baidu");
        System.out.println("1 " + user);

        try {
            User userN = deepCopy(user);
            System.out.println("2 " + userN);

            user.setName("baiduN");

            System.out.println("3 " + userN);

            userN.setName("baiduN2");

            System.out.println("4 " + userN);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
