package com.example.redis.RedisService.RedisServiceImpl;

import com.example.redis.model.User;
import com.example.redis.RedisService.redisService;
import com.example.redis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
@Service
public class redisServerviceImpl implements redisService {

   @Autowired
   private UserRepository userRepository;



    @Override
    public User save(User user)  {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User findUserByUserId(String userId) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
