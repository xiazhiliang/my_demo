package com.example.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author baidu
 * @date 2018/4/16 下午2:53
 * @description ${TODO}
 **/
public class OptionalTest {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setAddress("aaa");
        list.add(user);
        list.add(user);
        list.forEach(System.out::println);

        Optional<String> name = Optional.of("steven");
        Optional<String> someNull = Optional.empty();

        System.out.println(name.isPresent());
        System.err.println(someNull.isPresent());
    }
}
