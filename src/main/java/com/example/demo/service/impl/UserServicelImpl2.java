package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service(value = "impl2")
public class UserServicelImpl2 implements UserService {

    @Override
    public UserResponse getAllUsers() {
        UserResponse us = new UserResponse();
        us.setFname("John");
        us.setLname("Doe");
        us.setAge(40);
        us.setCell(BigInteger.valueOf(7526172930l));
        return us;
    }

    public UserResponse create(UserRequest user) {
        return null;
    }
}
