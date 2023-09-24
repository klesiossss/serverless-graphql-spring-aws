package com.serverless.example.service.impl;

import com.serverless.example.repository.dao.UserDao;
import com.serverless.example.repository.datafetcher.*;
import com.serverless.example.service.UserService;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Value("classpath:schema.graphqls")
    private Resource schemaResource;

    @Autowired
    private GetUserFetcher getUserFetcher;
    @Autowired
    private GetUsersFetcher getUsersFetcher;
    @Autowired
    private SaveUserFetcher saveUserFetcher;
    @Autowired
    private UpdateUserFetcher updateUserFetcher;
    @Autowired
    private DeleteUserFetcher deleteUserFetcher;
    private GraphQL graphQL;

    // load schema at application start up
    @PostConstruct
    public void loadSchema() throws IOException {
        File schemaFile = schemaResource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("user", getUserFetcher)
                        .dataFetcher("users", getUsersFetcher))
                .type("Mutation", typeWiring -> typeWiring
                        .dataFetcher("createUser", saveUserFetcher)
                        .dataFetcher("updateUser", updateUserFetcher)
                        .dataFetcher("deleteUser", deleteUserFetcher))
                .build();
    }

    public ExecutionResult getUsers(String query) {
        ExecutionResult result = graphQL.execute(query);
        return result;
    }

    public ExecutionResult getUserById(String query) {
        ExecutionResult result = graphQL.execute(query);
        return result;
    }

    public ExecutionResult createUser(String query) {
        ExecutionResult result = graphQL.execute(query);
        return result;
    }

    public ExecutionResult updateUser(String query) {
        ExecutionResult result = graphQL.execute(query);
        return result;
    }

    public ExecutionResult deleteUser(String query) {
        ExecutionResult result = graphQL.execute(query);
        return result;
    }


}
