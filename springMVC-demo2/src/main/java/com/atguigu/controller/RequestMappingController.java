package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/11 18:50
 * @since 1.0
 */
@Controller
// @RequestMapping("/test") // 设置映射请求的初始信息
public class RequestMappingController {

    // @RequestMapping("/")
    // public String index() {
    //     return "target";
    // }

    // @RequestMapping("/testRequestMapping") // 设置请求路径的具体信息
    // public String success() {
    //     return "success";
    // }

    @RequestMapping(
            // 配置多个请求，使用一个请求控制器处理
            value = {"/testRequestMapping", "hello"},
            // 配置请求方式，RequestMethod枚举类
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String success() {
        return "success";
    }

    // 通过派生注解的方式，设置请求方式
    @GetMapping("/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

}
