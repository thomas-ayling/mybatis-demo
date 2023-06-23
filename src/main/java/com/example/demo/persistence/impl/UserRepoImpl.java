package com.example.demo.persistence.impl;

import com.example.demo.model.User;
import com.example.demo.persistence.UserRepo;
import com.example.demo.persistence.impl.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepoImpl implements UserRepo {

    private final UserMapper userMapper;

    public UserRepoImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User create(User user, UUID userId) {
        user.setId(userId);
        userMapper.create(user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User get(UUID id) {
        return userMapper.get(id);
    }
}
