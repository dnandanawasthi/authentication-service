package com.auth.services.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auth.services.entity.User;
import com.auth.services.exception.ResourceNotAvailable;
import com.auth.services.service.UserService;

//for information @CrossOrigin can also managed thru annotation
@RestController
@RequestMapping({"/auth"})
public class UserResourcesImpl {

    @Autowired
    private UserService userService;

    /*@PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }*/
    @PostMapping(produces = { "application/json", "application/xml" })
    public ResponseEntity<?> addCard(@Valid @RequestBody User user){
        HttpHeaders responseHeader = new HttpHeaders();
        User addUser = userService.create(user);
        return new ResponseEntity<>(addUser, responseHeader, HttpStatus.CREATED);
    }

    @GetMapping(path = {"/{id}"}, produces = { "application/json", "application/xml" })
    public User findOne(@PathVariable("id") int id) throws ResourceNotAvailable {
        User user = userService.findById(id);
        if(user == null) {
            throw new ResourceNotAvailable(" Resource not available for "+ id);
        } else {
            return user;
        }
    }

    @GetMapping(path = {"/find"}, produces = { "application/json", "application/xml" })
    public User findByEmail(@RequestParam("email") String email, @RequestParam("password") String password) throws ResourceNotAvailable {
        User user = userService.findByEmailAndPassword(email,password);
        if(user == null) {
            throw new ResourceNotAvailable(" Resource not available for "+ email);
        } else {
            return user;
        }
    }

    @DeleteMapping(path ={"/{id}"})
    public User delete(@PathVariable("id") int id) throws ResourceNotAvailable {
        User user = userService.delete(id);
        if(user == null) {
            throw new ResourceNotAvailable(" Resource not available for "+ id);
        } else {
            return user;
        }
    }

}
