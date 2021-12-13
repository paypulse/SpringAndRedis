package com.example.redis.RedisExService.RedisExServiceImpl;


import com.example.redis.RedisExService.redisService;

import com.example.redis.model.RedisEx;

import com.example.redis.model.RedisHashEx;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class redisServerviceImpl implements redisService {



    @Resource(name= "redisTemplate")
    private ValueOperations<String,String> valueOps;

    @Resource(name= "redisTemplate")
    private ListOperations<String,String> listOps;

    @Resource(name= "redisTemplate")


    /**
     * String Example
     * */
    @Override
    public String stringSerialize(RedisEx redisEx) {

        try{
            valueOps.set(redisEx.getKey().toString(), redisEx.getValue().toString());
            return "key : " + redisEx.getKey() + ", change value : " + redisEx.getValue();
        }catch(Exception e){
            return e.toString();
        }

    }

    /**
     * List  Example
     * */
    @Override
    public String stringList(RedisEx redisEx) {

        try{
            for(RedisEx ex: redisEx.getRedisExList()){
                System.out.println(ex.getKey());
                listOps.rightPush(ex.getKey(),ex.getValue());
            }

            return listOps.range(redisEx.getRedisExList().get(0).getKey(),0,-1).toString();

        }catch (Exception  e){

            return e.toString();
        }
    }


    /**
     * Hash  Example
     * */
    @Override
    public String HashSerialize(RedisHashEx redisHashEx) {

        try{

        }catch(Exception e){
            return e.toString();
        }

        return null;
    }


}
