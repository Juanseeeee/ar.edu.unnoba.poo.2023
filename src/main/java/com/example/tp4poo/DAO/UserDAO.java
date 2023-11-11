package com.example.tp4poo.DAO;

import com.example.tp4poo.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {

    List<User> users;

    public UserDAO() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserByUsername(String username){
        return this.getUsers().stream()
                .filter((User user) -> {
                    return user.getUsername().equals(username);
                }).findFirst().get();
    }
}
