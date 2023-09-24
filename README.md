# Serverless Spring Boot Application
**Maintained by:** [Klesio Silva](klesiossss@gmail.com)

# Introduction
Developed to introduce serverless framework over spring boot with graphql-spring lib deployed in lambda with .

## Requirements

- AWS Account
- aws cli (must be configured with correct permissions to be able to deploy the app)
- npm (It is required to install serverless framework dependencies)
- serverless framework (npm install -g serverless)
- java11 and any IDE acceptable


## Architecture
![Draw](images/serverless-spring.jpg)
![API Gateway](images/apigateway.png)
## Basic Commands
# user
query User {
user(id: "79da92de-c7e4-4481-8964-dc520f76842f") {
id
name
email
}
}

# users

query Users {
users {
id
name
email
}
}


# create
mutation CreateUser {
createUser(input: {name: "pedro", email: "pedro@gmail.com"}) {
name
email
}
}


# update
mutation UpdateUser {
updateUser(input: {name: "antony swants", email: "antony@gmail.com"}, id: "79da92de-c7e4-4481-8964-dc520f76842f") {
id
name
email
}
}

# delete
mutation DeleteUser {
deleteUser(id: "79da92de-c7e4-4481-8964-dc520f76842f") {
id
name
email
}
}

## Tech Stack
 - Serverless Framework 
 - Spring Boot
 - Lambda
 - DynamoDB

## Pipeline
  - build
  - unitTes
  - integrationTest
  - featureTest
  - dev
  - staging
  - prod

Note: CI Stages are running by default but CD Stages configured as manual.



More API info could be found on swagger-ui by running locally and navigate http://localhost:8080/swagger-ui.html

## Local Development
### Preconditions
 - aws cli
 - npm
 - Serverless Framework

### Build
 - gradle build
 
### Deploy 
 - sls deploy --stage dev

### Destroy
 - sls remove --stage dev
