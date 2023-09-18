package com.solider.restful.controller;

import com.solider.restful.pojo.Employee;
import com.solider.restful.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/18 17:00
 * @since 1.0
 */
@Controller
public class EmployeeController {

    private EmployeeService employeeService = new EmployeeService();

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("emps", employeeService.getAll());
        return "index";
    }

    /**
     * 查询所有员工
     */
    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET
    )
    public String EmployeeList(Model model) {
        model.addAttribute("emps", employeeService.getAll());
        return "emp/emp_list";
    }

    /**
     * 添加员工
     */
    @RequestMapping(
            value ="/add",
            method = RequestMethod.POST
    )
    public String AddEmployee(Employee employee) {
        employeeService.save(employee);
        return "redirect:/all";
    }

    /**
     * 删除员工
     */
    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.DELETE
    )
    public String deleteEmp(@PathVariable("id") Integer id) {
        System.out.println("deleteEmp: " + id);
        employeeService.delete(id);
        return "redirect:/all";
    }

    /**
     * 查询单个员工信息
     */
    @RequestMapping(
            value = "/find/{id}",
            method = RequestMethod.GET
    )
    public String findEmp(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("emp", employeeService.get(id));
        return "emp/single_emp";
    }
}
