package com.yin.service;

import com.yin.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:/UserInfomation.properties")
public class UserService {
    @Value("${user.id}")
    private long id;

    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private int age;


    public User getUser(long id){
        return new User(this.id,this.name,this.age);
    }
}
