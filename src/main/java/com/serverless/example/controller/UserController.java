package com.serverless.example.controller;


import com.serverless.example.service.UserService;
import graphql.ExecutionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@RestController
@EnableWebMvc
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Object> getUser(@RequestBody String query) {
        ExecutionResult result =  userService.getUserById(query);
        return new ResponseEntity<Object>(result, HttpStatus.OK);
    }

}
