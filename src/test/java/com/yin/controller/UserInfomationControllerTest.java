package com.yin.controller;

import com.yin.entity.User;
import com.yin.response.UserResponse;
import com.yin.service.UserService;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MockMvcBuilderSupport;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class UserInfomationControllerTest {

    @Test
    public void getUser() throws  Exception{
        UserService userService = Mockito.mock(UserService.class);
        Mockito.when(userService.getUser(1L)).thenReturn(new User(1L,"tom",5));
        UserInfomationController userInfomationController = new UserInfomationController(userService);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userInfomationController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/user/getUser/{id}",1L)).andExpect(MockMvcResultMatchers.model().attributeExists("id"));

    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        UserResponse userResponse = restTemplate.getForObject("http://localhost:8080/user/getUser/{id}",UserResponse.class,2L);
        System.out.println(userResponse.toString());
    }
}