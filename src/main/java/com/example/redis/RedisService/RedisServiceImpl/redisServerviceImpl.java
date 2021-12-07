package com.example.redis.RedisService.RedisServiceImpl;

import com.example.redis.Domain.User;
import com.example.redis.RedisService.redisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

public class redisServerviceImpl implements redisService {

    @Autowired
    RedisTemplate<String,User> redisTemplate;

    private HashOperations hashOperations;


    public redisServerviceImpl(RedisTemplate<String,User> redisTemplate){
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public void save(User user) {
        hashOperations.put("USER", user.getId(), user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries("USER");
    }

    @Override
    public User findById(String id) {
        return (User) hashOperations.get("USER",id);
    }

    @Override
    public void update(User user) {
        save(user);

    }

    @Override
    public void delete(String id) {
        hashOperations.delete("USER",id);
    }
}
