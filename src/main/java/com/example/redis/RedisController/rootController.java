package com.example.redis.RedisController;


import com.example.redis.response.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class rootController {

    private static final Logger logger = LoggerFactory.getLogger(rootController.class);



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

    @GetMapping("/all")
    public ResponseEntity<CommonResponse> all(){

        return null;

    }



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView jspTest(ModelAndView mv) {
        mv.setViewName("/index");

        return mv;
    }
}
