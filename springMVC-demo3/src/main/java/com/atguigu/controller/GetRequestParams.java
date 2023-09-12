package com.atguigu.controller;

import com.atguigu.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/12 15:16
 * @since 1.0
 */
@Controller
@RequestMapping("/testRequestParams")
public class GetRequestParams {

    // SpringMVC获取请求参数

    // 1、通过ServletAPI获取请求参数
    @RequestMapping("/servletAPI")
    public String testServletAPI(HttpServletRequest request) {
        // 通过ServletAPI获取SESSIONID，创建浏览器的Cookie，然后通过@CookieValue访问
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("{username:" + username + ", \n" + "password:" + password + "}");
        return "success";
    }

    // 2、通过控制器方法的形参获取请求参数
    @RequestMapping("/dispatcherMethod")
    public String testDispatcherMethod(String username, String password, String hobbies) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("hobbies = " + hobbies);
        // Arrays.stream(hobbies).forEach(System.out::println);
        return "success";
    }

    // 3、通过@RequestParam注解，设置请求参数
    @RequestMapping("/requestParam")
    public String testRequestParam(@RequestParam(value = "username", required = false) String username,
                                   @RequestParam("password") String password) {
        System.out.println("{username:" + username + ", \n" + "password:" + password + "}");
        return "success";
    }

    // 4、通过@RequestHeader注解，获取请求头信息
    @RequestMapping("/requestHeader")
    public String testRequestHeader(@RequestHeader("Host") String host, @RequestHeader("Origin") String origin) {
        System.out.println("{host:" + host + ", \n" + "origin:" + origin + "}");
        return "success";
    }

    // 5、通过@CookieValue注解，获取cookie数据
    @RequestMapping("/cookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String JSESSIONID) {
        System.out.println("JSESSIONID = " + JSESSIONID);
        return "success";
    }

    // 6、通过POJO实体类，映射获取请求参数
    @RequestMapping("/testPOJO")
    public String testPOJO(User user) {
        System.out.println(user);
        return "success";
    }
}
