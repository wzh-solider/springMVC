package com.atguigu.mvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/13 16:32
 * @since 1.0
 */
@Controller
@RequestMapping("/scope")
public class ScopeObjectsShareData {

    // 域对象共享数据

    // 共享请求域中的数据
    // 1、使用ServletAPI向request域中共享数据
    @RequestMapping("/servletAPI")
    public String testServletAPI(HttpServletRequest request) {
        request.setAttribute("scope", "servletAPI");
        return "success";
    }

    // 2、使用ModelAndView向request域中共享数据
    /**
     * ModelAndView有Model和View两个作用
     * Model主要用于向请求域共享数据
     * View主要用于设置视图，实现页面跳转
     */
    @RequestMapping("/modelAndView")
    public ModelAndView testModelAndView(ModelAndView mav) {
        // ModelAndView modelAndView = new ModelAndView();

        // 使用Model向request域中共享数据
        mav.addObject("scope", "modelAndView");
        // 设置视图，实现页面跳转
        mav.setViewName("success");
        return mav;
    }

    // 3、使用Model向request域中共享数据
    @RequestMapping("/model")
    public String testModel(Model model) {
        model.addAttribute("scope", "model");
        System.out.println(model.getClass().getName());
        return "success";
    }

    // 4、使用Map向request域中共享数据
    @RequestMapping("/map")
    public String testMap(Map<String, Object> map) {
        map.put("scope", "map");
        System.out.println(map.getClass().getName());
        return "success";
    }

    // 5、使用ModelMap向request域中共享数据
    @RequestMapping("/modelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("scope", "modelMap");
        System.out.println(modelMap.getClass().getName());
        return "success";
    }


    // 共享会话域中的数据
    @RequestMapping("/session")
    public String testSession(HttpSession session) {
        session.setAttribute("sessionScope", "session");
        System.out.println(session);
        return "success";
    }

    // 共享应用域中的数据
    @RequestMapping("/application")
    public String testApplication(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("applicationScope", "application");
        System.out.println(servletContext);
        return "success";
    }
}
