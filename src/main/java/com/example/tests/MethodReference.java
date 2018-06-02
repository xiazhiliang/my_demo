package com.example.tests;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author baidu
 * @date 2018/4/16 下午3:24
 * @description ${TODO}
 **/
public class MethodReference {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("xia", "zhi", "ang", "yao", "fa");
        list.sort(Comparator.comparing(e -> e));
//        System.out.println(list);

        String[] array = {"xia", "zhi", "ang", "yao", "fa"};
//        Arrays.sort(array,(item1,item2)->item1.compareTo(item2));
//        Arrays.sort(array,Comparator.naturalOrder());
        Arrays.sort(array, String::compareToIgnoreCase);

        Arrays.stream(array).forEach(System.out::println);
    }
}
