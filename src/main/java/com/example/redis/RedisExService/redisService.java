package com.example.redis.RedisExService;

import com.example.redis.model.RedisEx;
import com.example.redis.model.RedisHashEx;
import org.springframework.stereotype.Service;

import java.util.List;


public interface redisService {

    /**
     * String  Example
     * */
    String stringSerialize(RedisEx redisEx);

    /**
     * List  Example
     * */
    String stringList(RedisEx redisEx);


    /**
     * Hash  Example
     * */
    String HashSerialize(RedisHashEx redisHashEx);

    /**
     * Set  Example
     * */

    /**
     * sorted Set Example
     * */
}
