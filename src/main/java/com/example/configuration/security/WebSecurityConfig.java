package com.example.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author baidu
 * @date 2018/6/5 下午9:42
 * @description ${TODO}
 **/

@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

    @Bean
    public UserDetailsService userDetailsService() throws Exception {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        User user = (User) users.username("user").password("password").roles("USER").build();
        User admin = (User) users
                .username("admin")
                .password("password")
                .roles("USER","ADMIN")
                .build();

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
        return manager;
    }


}

