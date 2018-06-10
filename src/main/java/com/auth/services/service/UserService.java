package com.auth.services.service;

import com.auth.services.entity.User;

public interface UserService {

    User create(User user);

    User delete(int id);

    User findById(int id);

    User findByEmailAndPassword(String email, String password);

}
