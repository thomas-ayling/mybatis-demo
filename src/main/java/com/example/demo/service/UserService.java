package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    /**
     * @param user user to be saved
     */
    User create(User user);

    /**
     * @return a list of all users
     */
    List<User> getAll();

    User get(UUID id);
}
