package com.example.redis.RedisExService;

import com.example.redis.model.RedisEx;
import com.example.redis.model.RedisHashEx;
import org.springframework.stereotype.Service;

import java.util.List;


public interface redisService {

    /**
     * String  Example
     * 일반적으로 사용되는 key-value 형식의 자료구조 key와 value는 1:1
     * */
    String stringSerialize(RedisEx redisEx);

    /**
     * String Example key 삭제
     * */
    String deleteKey(String key);

    /**
     * List  Example
     * Strings의 묶음 자료구조 입니다.
     * last or first에 삽입,삭제가 가능 하다.
     * */
    String stringList(RedisEx redisEx);

    /**
     * List index의 0쪽 부터 push 예제
     * */
    String stringListLeftPush(RedisEx redisEx);

    /**
     * List left index 삭제
     * **/
    String stringListLeftPop(RedisEx redisEx);

    /**
     * List right index 삭제
     * */
    String stringListRightPop(RedisEx redisEx);



    /**
     * Hash  Example
     * 내부에 또 다른 key-value로 이루어진 자료 구조
     * key 하나에 field와 value쌍을 40억개 까지 저장 가능
     * */
    String HashSerialize(RedisHashEx redisHashEx);


    /**
     *  Hash HashPutIfAbsent 이게 뭐지?
     * **/
    String HashPutIfAbsent(RedisHashEx redisHashEx);



    /**
     * Set  Example
     * 중복 되지 않는 값을 데이터로 가지는 collection입니다. 때문에 동일한 값을 입력하면,
     * 하나의 값만 남는다.
     * */


    /**
     * sorted Set Example
     * */
}
