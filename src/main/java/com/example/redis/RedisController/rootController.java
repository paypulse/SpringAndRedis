package com.example.redis.RedisController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


@Controller
public class rootController {

    private static final Logger logger = LoggerFactory.getLogger(rootController.class);

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Resource(name="redisTemplate")
    private ValueOperations<String,String> valueOps;

    @RequestMapping(value="/jedis2")
    public ModelAndView jedis2()
    {
        ModelAndView mv = new ModelAndView();

        valueOps.set("foo","bar");
        logger.info("Welcome jedis user {}.", valueOps.get("foo"));

        mv.setViewName("/index");
        return mv;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView jspTest(ModelAndView mv) {
        mv.setViewName("/index");

        return mv;
    }
}
