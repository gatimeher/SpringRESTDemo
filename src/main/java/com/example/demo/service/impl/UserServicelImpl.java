package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service(value = "impl1")
public class UserServicelImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse getAllUsers() {
        User user = userRepository.findById(1L);
        UserResponse us = new UserResponse();
        us.setFname(user.getFirstName());
        us.setLname(user.getLastName());
        us.setAge(user.getAge());
        us.setCell(user.getCellNumber());
        return us;
    }

    public UserResponse create(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFname());
        user.setLastName(userRequest.getLname());
        user.setAge(userRequest.getAge());
        user.setCellNumber(userRequest.getCell());
        user = userRepository.save(user);
        UserResponse us = new UserResponse();
        us.setFname(user.getFirstName());
        us.setLname(user.getLastName());
        us.setAge(user.getAge());
        us.setCell(user.getCellNumber());
        return us;
    }
}
