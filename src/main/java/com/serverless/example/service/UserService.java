package com.serverless.example.service;


import graphql.ExecutionResult;

public interface UserService {
    ExecutionResult getUsers(String query);

    ExecutionResult getUserById(String id);

    ExecutionResult createUser(String query);

    ExecutionResult updateUser(String query);

    ExecutionResult deleteUser(String query);
}
