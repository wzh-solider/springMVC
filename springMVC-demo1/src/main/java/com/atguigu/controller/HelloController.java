package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/11 15:45
 * @since 1.0
 */
@Controller // 创建请求控制器，标识控制器组件
public class HelloController {

    // 创建请求方法
    // @RequestMapping注解：处理请求和控制器方法之间的映射关系
    // @RequestMapping注解的value属性，可以通过请求地址匹配请求，'/'表示当前工程的上下文路径
    // localhost:8080/springMVC/
    @RequestMapping("/")
    public String index() {
        // 设置视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String target() {
        return "target";
    }
}
