package com.yin.service;

import com.yin.config.WebConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
//@WebAppConfiguration
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUser() {
        System.out.println(userService.getUser(1L).toString());
    }
}