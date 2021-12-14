package com.example.redis.RedisExController;


import com.example.redis.RedisExService.redisService;
import com.example.redis.model.RedisEx;
import com.example.redis.common.response.CommonResponse;
import com.example.redis.model.RedisHashEx;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
public class rootController {

    private static final Logger logger = LoggerFactory.getLogger(rootController.class);

    //redis
    @Autowired
    private redisService redis;

    /**
     *  String serialize 예제
     * **/
    @RequestMapping(value="/stringExample" , method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> stringExample(HttpServletRequest req, HttpServletResponse res, @RequestBody RedisEx redisEx){


        return ResponseEntity.ok(CommonResponse.builder()
                .data(redis.stringSerialize(redisEx))
                .status("SUCCESS")
                .msg("stringSerialize")
                .build());
    }

    /**
     * String delete key
     * **/
    @RequestMapping(value = "/deleteStringKey", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> deleteStringKey(HttpServletRequest req, HttpServletResponse res, @RequestParam String key){

        return ResponseEntity.ok(CommonResponse.builder()
                .data(redis.deleteKey(key))
                .status("SUCCESS")
                .msg("stringSerialize")
                .build());
    }

    /**
     *  List Deserialize 예제
     * */
    @RequestMapping(value="/listExample" , method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> ListExample(HttpServletRequest req, HttpServletResponse res ,@RequestBody RedisEx redisExList){

        return ResponseEntity.ok(CommonResponse.builder()
                .data(redis.stringList(redisExList))
                .status("SUCCESS")
                .msg("stringSerialize")
                .build());
    }

    /**
     * List index의 0쪽 부터 push 예제
     * */
    @RequestMapping(value="/listLeftPushExample", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> ListLeftPushExample(HttpServletRequest req, HttpServletResponse res ,@RequestBody RedisEx redisExList){

        return ResponseEntity.ok(CommonResponse.builder()
                .data(redis.stringListLeftPush(redisExList))
                .status("SUCCESS")
                .msg("listLeftPushExample")
                .build());
    }


    /**
     * Hash Example 예제
     * */
    @RequestMapping(value = "/hashExample" , method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> HashExample(HttpServletRequest req, HttpServletResponse res ,@RequestBody RedisHashEx redisExHash){

        return ResponseEntity.ok(CommonResponse.builder()
                .data(redis.HashSerialize(redisExHash))
                .status("SUCCESS")
                .msg("stringSerialize")
                .build());
    }


    /**
     * Hash HashPutIfAbsent예제
     * */
    @RequestMapping(value = "/hashPutIfAbsent" , method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> hashPutIfAbsent(HttpServletRequest req, HttpServletResponse res ,@RequestBody RedisHashEx redisExHash){

        return ResponseEntity.ok(CommonResponse.builder()
                .data(redis.HashPutIfAbsent(redisExHash))
                .status("SUCCESS")
                .msg("stringSerialize")
                .build());
    }




    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView jspTest(ModelAndView mv) {
        mv.setViewName("/index");

        return mv;
    }
}
