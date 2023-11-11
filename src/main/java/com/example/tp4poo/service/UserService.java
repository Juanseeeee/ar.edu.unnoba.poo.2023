package com.example.tp4poo.service;

import com.example.tp4poo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public User create(User user);
    public List<User> getUsers();

}
