package com.example.redis.RedisController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class rootController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView jspTest(ModelAndView mv) {
        mv.setViewName("/index");

        return mv;
    }
}
