package org.simple.mybatis.service;

import org.simple.mybatis.mapper.EmployeeMapper;
import org.simple.mybatis.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> selectByNameOrEmail(Employee employee){
        return  employeeMapper.selectListByInnerParam(employee);
    }
}
