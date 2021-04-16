package org.simple.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.simple.mybatis.entity.Employee;

import java.util.List;

public interface EmployeeMapper {

    public List<Employee> selectByNameOrEmail(@Param("name") String name,@Param("email") String email);

    public int batchInsert(@Param("employeeList") List<Employee> employeeList);

    public int updateById(@Param("employee") Employee employee);
}
