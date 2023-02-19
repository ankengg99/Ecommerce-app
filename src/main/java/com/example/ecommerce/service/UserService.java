package com.example.ecommerce.service;

import com.example.ecommerce.dao.UserRepository;
import com.example.ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    public void addUser(User user){
        repository.save(user);

    }
    public User getUser(Integer id){
        return repository.findById(id).get();
    }
}
