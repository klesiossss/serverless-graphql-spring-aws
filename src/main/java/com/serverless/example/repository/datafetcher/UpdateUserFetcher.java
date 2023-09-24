package com.serverless.example.repository.datafetcher;

import com.serverless.example.repository.dao.UserDao;
import com.serverless.example.repository.entity.User;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class UpdateUserFetcher implements DataFetcher<User> {
    @Autowired
    UserDao userDao;
    @Override
    public User get(DataFetchingEnvironment environment) {
        HashMap<String,String> user = environment.getArgument("input");
        String id  = environment.getArgument("id");
        User userAux = new User();
        if(userDao.findById(id)==null){
            throw new RuntimeException("user not found!");
        }
        userAux.setId(id);
        userAux.setName(user.get("name"));
        userAux.setEmail(user.get("email"));
        return userDao.save(userAux);
    }
}
