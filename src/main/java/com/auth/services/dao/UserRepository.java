package com.auth.services.dao;

import org.springframework.data.repository.Repository;

import com.auth.services.entity.User;

// Reference for below queries
// "https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation"
public interface UserRepository extends Repository<User, Integer> {

    void delete(User user);

    User findOne(int id);

    User findByEmailAndPassword(String email, String password);

    User save(User user);
}
