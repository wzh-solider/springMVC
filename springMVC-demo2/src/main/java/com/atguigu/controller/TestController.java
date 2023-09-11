package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/11 17:54
 * @since 1.0
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
