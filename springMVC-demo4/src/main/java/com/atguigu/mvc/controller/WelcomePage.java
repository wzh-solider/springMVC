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

    // 请求控制器的控制器方法中，没有处理请求的业务代码，而单单只是返回一个视图名，
    // 那么可以使用<mvc:view-controller>标签来简化配置
    // <mvc:view-controller path="/" view-name="index"/>

    // @RequestMapping("/")
    // public String welcome() {
    //     return "index";
    // }

    @RequestMapping("/test_view")
    public String testView() {
        return "test_view";
    }

}
