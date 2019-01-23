package com.example.demo.endpoint;

import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserEndPoint {

    @Autowired
    @Qualifier(value = "impl1")
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public HttpEntity<UserResponse> getAllUsers() {
        UserResponse us = userService.getAllUsers();
        return new ResponseEntity<>(us, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public HttpEntity<String> getAllUsers(@RequestBody UserRequest userRequest) {
        UserResponse user = userService.create(userRequest);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
}