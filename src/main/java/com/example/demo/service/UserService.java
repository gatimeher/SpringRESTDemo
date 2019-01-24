package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;

public interface UserService {

    public UserResponse getAllUsers();

    public UserResponse getUserById(Long id) throws UserNotFoundException;

    public UserResponse create(UserRequest user);
}
