package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/13 16:27
 * @since 1.0
 */
@Controller
public class WelcomePage {

    // 域对象共享数据

    @RequestMapping("/")
    public String welcome(){
        return "index";
    }
}
