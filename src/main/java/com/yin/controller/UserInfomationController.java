package com.yin.controller;

import com.yin.entity.User;
import com.yin.response.UserResponse;
import com.yin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserInfomationController {


    private UserService userService;

    @Autowired
    public UserInfomationController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/getUser/{id}",produces = "application/json")
    public UserResponse getUser(@PathVariable(name = "id") long id){
        System.out.println("----------------:"+id);
        User user = userService.getUser(id);
        UserResponse userResponse = new UserResponse();
        userResponse.convert(user);
        return userResponse;
    }
}
