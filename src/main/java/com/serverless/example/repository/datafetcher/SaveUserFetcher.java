package com.serverless.example.repository.datafetcher;

import com.serverless.example.repository.dao.UserDao;
import com.serverless.example.repository.entity.User;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SaveUserFetcher implements DataFetcher<User> {
    @Autowired
   UserDao userDao;

    @Override
    public User get(DataFetchingEnvironment environment) {
            HashMap<String,String> user = environment.getArgument("input");
            User userAux = new User();
            userAux.setName(user.get("name"));
            userAux.setEmail(user.get("email"));
            return userDao.save(userAux);
    }
}
