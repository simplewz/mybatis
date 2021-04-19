package org.simple.mybatis.controller;

import org.simple.mybatis.entity.Employee;
import org.simple.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/queryEmployeeByNameOrEmail")
    public String getEmployeeByNameOrEmail(@RequestParam("name") String name, @RequestParam("email") String email, Map<String,Object> map){
        List<Employee> employeeList=employeeService.selectByNameOrEmail(new Employee(null,name,null,email,null));
        System.out.println(employeeList);
        map.put("employeeList",employeeList);
        return "list";
    }
}
