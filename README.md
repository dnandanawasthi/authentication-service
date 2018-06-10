Service has capability to return JSON or XML response based on quey parameter

Steps to run authentication-service application

Command to build application: mvn clean install

Command to build docker image of application: mvn clean package docker:build

Command to build run docker image: docker run -it -p 8081:8081 auth-service

Command to stop all the container docker stop $(docker ps -a -q)

Command to remove all the container docker rm $(docker ps -a -q)

Command to remove all the image docker rmi -f $(docker images -q)

Below are the sample URLs to test application using Postman or browser

http://localhost:8081/user-auth/auth

Body:
{
    "id": 1,
    "firstName": "nandan",
    "lastName": "awasthi",
    "email": "nandan@gmail.com",
    "password": "nandan"
}

http://localhost:8081/user-auth/auth/1

For Json response
http://localhost:8081/user-auth/auth/1?mediaType=json

For XML response
http://localhost:8081/user-auth/auth/1?mediaType=xml

http://localhost:8081/user-auth/auth/1