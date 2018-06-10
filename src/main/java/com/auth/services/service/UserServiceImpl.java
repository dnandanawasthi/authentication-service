package com.auth.services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.services.dao.UserRepository;
import com.auth.services.entity.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User create(final User user) {
        return repository.save(user);
    }

    @Override
    public User delete(final int id) {
        User user = findById(id);
        if(user != null){
            repository.delete(user);
        }
        return user;
    }

    @Override
    public User findById(final int id) {
        return repository.findOne(id);
    }

    @Override
    public User findByEmailAndPassword(final String email, final String password) {
        return repository.findByEmailAndPassword(email, password);
    }

}
