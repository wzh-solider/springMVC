package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
            method = {RequestMethod.GET, RequestMethod.POST},

            // 配置请求参数，必须同时满足
            params = {"username=admin", "password!=123456"}
    )
    public String success() {
        return "success";
    }

    // 通过派生注解的方式，设置请求方式
    @GetMapping("/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    // 规定请求头
    @RequestMapping(
            value = "/testRequestHeaders",
            headers = {"Host=localhost:8080"}
    )
    public String testHeaders() {
        return "success";
    }

    // @RequestMapping适配Ant风格路径
    // @RequestMapping("/a?a/testAnt") // ?可以匹配任意的单个字符
    // @RequestMapping("/a*a/testAnt") // *可以匹配0到多个字符
    // @RequestMapping("/**/testAnt") // **表示匹配任意的一层或多层目录
    // public String testAnt() {
    //     return "success";
    // }

    // SpringMVC支持路径中传入的参数
    // 原始方式：/deleteUser?1
    // rest方式：/deleteUser/1 ==> 不再通过?的形式传入参数，而是将数据放到路径中
    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(@PathVariable("id") String id, @PathVariable("username") String username) {
        // 可以获取请求参数，对请求参数进行处理，然后返回给相应的页面
        System.out.println("id = " + id + "\nusername = " + username);
        return "success";
    }
}
