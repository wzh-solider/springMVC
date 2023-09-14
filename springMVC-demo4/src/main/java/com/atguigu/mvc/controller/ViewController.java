package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/14 17:24
 * @since 1.0
 */
@Controller
public class ViewController {

    // @RequestMapping("/test_view")
    // public String testView(){
    //     return "test_view";
    // }


    // 测试Thymeleaf视图
    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }

    // 测试转发视图
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }

    // 测试重定向视图
    @RequestMapping("/testRedirectView")
    public String testRedirectView(){
        return "redirect:/testThymeleafView";
    }
}
