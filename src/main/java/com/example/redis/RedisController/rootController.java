package com.example.redis.RedisController;


import com.example.redis.RedisService.redisService;
import com.example.redis.model.User;
import com.example.redis.response.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class rootController {

    private static final Logger logger = LoggerFactory.getLogger(rootController.class);

    //redis
    private redisService redis;


    /**
     * REDIS CRUD API 만들기
     * 기능 : Insert
     * version1
     * */

//    @RequestMapping(value="/insertData")
//    public ResponseEntity<CommonResponse> insertData(){
//
//
//        User users = new User();
//        users.setId("test");
//        users.setName("testName");
//        users.setSalary(32L);
//
//
//        valueOps.set("foo",users.getId().toString());
//
//
//        return ResponseEntity.ok(CommonResponse.builder()
//                .data(valueOps.get("foo").toString())
//                .status("SUCCESS")
//                .msg("Insert complate")
//                .build());
//    }


    /**
     * 사용자 등록 (CRUD)
     *
     * **/
    @RequestMapping(value="/registUser", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> registUser(HttpServletRequest req, HttpServletResponse res, @RequestBody User user){

        redis.save(user);
        System.out.println(redis.save(user));

        return ResponseEntity.ok(CommonResponse.builder()
                .data("test")
                .status("SUCCESS")
                .msg("registUser")
                .build());

    }





    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView jspTest(ModelAndView mv) {
        mv.setViewName("/index");

        return mv;
    }
}
