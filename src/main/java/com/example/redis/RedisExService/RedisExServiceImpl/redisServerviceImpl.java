package com.example.redis.RedisExService.RedisExServiceImpl;


import com.example.redis.RedisExService.redisService;
import com.example.redis.model.RedisEx;
import com.example.redis.model.RedisHashEx;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class redisServerviceImpl implements redisService {



    @Resource(name= "redisTemplate")
    private ValueOperations<String,String> valueOps;

    @Resource(name= "redisTemplate")
    private ListOperations<String,String> listOps;

    @Resource(name= "redisTemplate")
    private HashOperations<String,String,String> hashOps;


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

    @Override
    public String deleteKey(String key) {
        try{
            valueOps.getOperations().delete(key);
            return "delete key : " + key;
        }catch (Exception e){
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

    @Override
    public String stringListLeftPush(RedisEx redisEx) {
        try{
            listOps.leftPush(redisEx.getKey(), redisEx.getValue());
            return listOps.range(redisEx.getKey(),0,-1).toString();

        }catch (Exception e){
            return e.toString();
        }

    }

    @Override
    public String stringListLeftPop(RedisEx redisEx) {
        try{
            listOps.leftPop(redisEx.getKey());
            return listOps.range(redisEx.getKey(), 0,-1).toString();
        }catch (Exception e){
            return e.toString();
        }

    }

    @Override
    public String stringListRightPop(RedisEx redisEx) {
        try{
            listOps.rightPop(redisEx.getKey());
            return listOps.range(redisEx.getKey(), 0, -1).toString();

        }catch(Exception e){
            return e.toString();
        }
    }


    /**
     * Hash  Example
     * */
    @Override
    public String HashSerialize(RedisHashEx redisHashEx) {

        try{
            hashOps.put(redisHashEx.getKey(), redisHashEx.getFeild(), redisHashEx.getValue());
            return hashOps.get(redisHashEx.getKey(), redisHashEx.getFeild());

        }catch(Exception e){
            return e.toString();
        }

    }

    @Override
    public String HashPutIfAbsent(RedisHashEx redisHashEx) {
       try{
           hashOps.putIfAbsent(redisHashEx.getKey(), redisHashEx.getFeild(), redisHashEx.getValue());
           return hashOps.get(redisHashEx.getKey(),redisHashEx.getFeild());
       }catch(Exception e){
           return e.toString();
       }
    }


}
