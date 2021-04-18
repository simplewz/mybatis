package org.simple.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.simple.mybatis.entity.Employee;

import java.lang.annotation.ElementType;
import java.util.List;

public interface EmployeeMapper {

    public Employee selectById(@Param("id") String id);

    //测试<where>标签与<if>标签的结合使用构造动态查询SQL
    public List<Employee> selectByNameOrEmail(@Param("name") String name,@Param("email") String email);

    //测试<trim>标签用于构造动态查询SQL
    public List<Employee> selectList(Employee employee);

    //测试choose when case 标签  相当于Java中的switch
    public List<Employee> selectByConditionChoose(@Param("employee") Employee employee);

    //测试<foreach>标签用于构造批量插入的动态SQL
    public int batchInsert(@Param("employeeList") List<Employee> employeeList);

    //测试<set>标签与<if>标签结合使用构造动态修改SQL语句
    public int updateById(@Param("employee") Employee employee);

    //使用trim标签代替<set>标签与<if>标签的动态修改
    public int updateByIdUseTrim(@Param("employee") Employee employee);

}
