package com.example.tp4poo.service;


import com.example.tp4poo.DAO.UserDAO;
import com.example.tp4poo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
        User user = new User("juanse","juanse@123",new BCryptPasswordEncoder().encode("1234"));
        userDAO.addUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Crea una instancia de UserDAO y llama al método getUserByUsername
        User user = userDAO.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return user;
    }

    @Override
    public User create(User user) {
        user.setName(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userDAO.addUser(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }


}
