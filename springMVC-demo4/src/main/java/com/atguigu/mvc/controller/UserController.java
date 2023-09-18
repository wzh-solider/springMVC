package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/17 16:37
 * @since 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 使用RESTFul模拟用户资源查询
     * /user GET 查询所有用户信息
     * /user/1 GET 根据用户id查询用户信息
     * /user POST 添加用户信息
     * /user PUT 修改用户信息
     * /user/1 DELETE 根据用户id删除用户信息
     */

    @RequestMapping(
            value = "",
            method = RequestMethod.GET
    )
    public String userList() {
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public String getUserById(@PathVariable("id") String id) {
        System.out.println("根据用户id查询用户信息");
        return "success";
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.POST
    )
    public String addUser(String username, String password) {
        System.out.println("添加用户信息：username = " + username + ", password = " + password);
        return "success";
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE
    )
    public String deleteUserById(@PathVariable("id") String id) {
        System.out.println("根据用户id删除用户信息：id = " + id);
        return "success";
    }

    @RequestMapping(
            value = "",
            method = RequestMethod.PUT
    )
    public String updateUser(String username, String password) {
        System.out.println("修改用户信息：username = " + username + ", password = " + password);
        return "success";
    }

}
