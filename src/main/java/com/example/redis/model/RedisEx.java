package com.example.redis.model;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RedisEx {

    //key
    String key;
    //value
    String value;

    //List
    List<RedisEx> redisExList;

}
