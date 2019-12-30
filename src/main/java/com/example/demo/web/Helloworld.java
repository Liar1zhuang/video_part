package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author denakira
 * @date 2019/12/23 3:45 下午
 */
@Controller
public class Helloworld {
    @RequestMapping("/index")
    public String Hello(){
        return "test";
    }
}
