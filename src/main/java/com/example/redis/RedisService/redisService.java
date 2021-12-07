package com.example.redis.RedisService;

import com.example.redis.Domain.User;

import java.util.Map;

public interface redisService {

    void save(User user);
    Map<String,User> findAll();
    User findById(String id);
    void update(User user);
    void delete(String id);

}
