package com.example.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author baidu
 * @date 2018/4/23 下午5:22
 * @description ${TODO}
 **/
public class MapMerge {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setId(1L);
        user.setName("xia");
        User user1 = new User();
        user1.setId(1L);
        user1.setName("zhiliang");
        list.add(user);
        list.add(user1);

        Map<Long, User> map = list.stream().collect(Collectors.toMap(User::getId, item -> item, (item, item2) -> item2));
        System.out.println(map);

    }
}
