package com.example.redis.RedisService;

import com.example.redis.model.User;

import java.util.Map;


public interface redisService {


    public User save(User user);
    public User update(User user);
    public User findUserByUserId(String userId);
    public User findById(Long id);
    public void remove(Long id);

}
