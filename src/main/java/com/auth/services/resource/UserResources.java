package com.auth.services.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.auth.services.entity.User;

public interface UserResources {

    public User create(@RequestBody User user);

    public User findOne(@PathVariable("id") int id);

    public User findByEmail(@RequestParam("email") String email, @RequestParam("password") String password);

    public User delete(@PathVariable("id") int id);

}
