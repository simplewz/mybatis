package org.simple.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.simple.mybatis.entity.Employee;

public interface EmployeeMapper {

    //注解和xml配置文件同时生效时，不能对同一个方法使用既使用注解又使用xml配置,mybatis框架会抛出异常
    //java.lang.IllegalArgumentException: Mapped Statements collection already contains value for org.simple.mybatis.mapper.EmployeeMapper.selectById. please check org/simple/mybatis/mapper/EmployeeMapper.xml and org/simple/mybatis/mapper/EmployeeMapper.java (best guess)
    //@Select("select * from employee where id = #{id}")
    public Employee selectById(@Param("id") String id);

    /**
     * mybatis允许增删改操作直接定义以下类型的返回值:
     * Integer/int Long/long:返回影响的行数
     * boolean/Boolean: 如果受影响的行数大于0，则返回true,否则返回false
     */
    public void insert(Employee employee);

    /**
     * 如果mysql的数据表中的主键设置为自增主键，mybatis可以获取到自增主键的值
     * 其获取的底层原理是通过原生jdbc的statement.getGeneratedKeys()方法获取
     * @param employee
     */
    public void insertWithGenerateKey(Employee employee);

    public void updateById(Employee employee);

    public boolean deleteById(String id);

}
