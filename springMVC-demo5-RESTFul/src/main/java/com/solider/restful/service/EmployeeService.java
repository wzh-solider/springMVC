package com.solider.restful.service;

import com.solider.restful.pojo.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Solider
 * @version 1.0
 * @Date 2023/9/18 16:43
 * @since 1.0
 */
public class EmployeeService {
    private static Map<Integer, Employee> employees;

    static {
        employees = new HashMap<>();

        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", "男"));
        employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", "男"));
        employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", "女"));
        employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", "女"));
        employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", "男"));
    }

    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee get(Integer id) {
        return employees.get(id);
    }

    public void delete(Integer id) {
        employees.remove(id);
    }
}
