package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.persistence.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public User create(User user) {
        UUID userId = UUID.randomUUID();

        return userRepo.create(user, userId);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userRepo.getAll();
    }

    @Override
    public User get(UUID id) {
        return userRepo.get(id);
    }
}
