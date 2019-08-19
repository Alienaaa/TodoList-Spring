package com.alien.TodoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alien.TodoList.pojo.User;
import com.alien.TodoList.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // insert new test data
    @GetMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "saved successfully";
    }

    // get all test data
    @GetMapping(path="/all")
    public  Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
