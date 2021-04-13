package org.simple.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.simple.mybatis.entity.Employee;

public interface EmployeeMapper {

    //注解和xml配置文件同时生效时，不能对同一个方法使用既使用注解又使用xml配置,mybatis框架会抛出异常
    //java.lang.IllegalArgumentException: Mapped Statements collection already contains value for org.simple.mybatis.mapper.EmployeeMapper.selectById. please check org/simple/mybatis/mapper/EmployeeMapper.xml and org/simple/mybatis/mapper/EmployeeMapper.java (best guess)
    //@Select("select * from employee where id = #{id}")
    public Employee selectById(@Param("id") String id);

}
