package com.serverless.example.repository.datafetcher;

import com.serverless.example.repository.dao.UserDao;
import com.serverless.example.repository.entity.User;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetUserFetcher implements DataFetcher<User> {
   @Autowired
    UserDao userDao;

    @Override
    public User get(DataFetchingEnvironment environment) {
        String userId = environment.getArgument("id");
        Optional<User> user = userDao.findById(userId);
        if(user.get()==null){
            throw new RuntimeException("User not found");
        }else {
            return user.get();
        }
    }
}
