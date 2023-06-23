package com.example.demo.persistence;

import com.example.demo.model.User;

import java.util.List;
import java.util.UUID;

public interface UserRepo {
    User create(User user, UUID userId);

    List<User> getAll();

    User get(UUID id);
}
