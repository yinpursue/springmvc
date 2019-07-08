package com.yin.response;

import com.yin.entity.User;
import com.yin.exception.UserException;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class UserResponse {

    private long id;
    private String name;
    private int age;

    public UserResponse convert(User user) {
        try {
            BeanUtils.copyProperties(this,user);
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserException("001","属性转换出错",e);
        }
    }


    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
