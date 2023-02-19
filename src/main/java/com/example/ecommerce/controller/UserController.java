package com.example.ecommerce.controller;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService service;
    @PostMapping("/user")
    public String saveUser(@RequestBody User user){
        service.addUser(user);
        return "user saved";
    }
    @GetMapping("/user/id/{id}")
    public User getUser(@PathVariable Integer id){
        return service.getUser(id);
    }
}
