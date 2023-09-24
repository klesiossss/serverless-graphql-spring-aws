package com.serverless.example.repository.datafetcher;

import com.serverless.example.repository.dao.UserDao;
import com.serverless.example.repository.entity.User;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUsersFetcher implements DataFetcher<List<User>> {
    @Autowired
    UserDao userDao;
    @Override
    public List<User> get(DataFetchingEnvironment environment) {
        return userDao.findAll();
    }
}
