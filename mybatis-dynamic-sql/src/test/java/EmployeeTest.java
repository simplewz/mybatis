import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.simple.mybatis.entity.Employee;
import org.simple.mybatis.mapper.EmployeeMapper;
import org.simple.mybatis.util.SqlSessionFactoryUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RunWith(JUnit4.class)
public class EmployeeTest {
    @Test
    public void test() throws IOException {
        //1. 创建一个SQlSessionFactory连接工厂
        String resource="config/mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtil.createSqlSessionFactory(resource);
        //2. 创建SqlSession
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        try{
            //3. 根据SqlSession获取Mapper对象,该Mapper对象为动态代理对象
            EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
            //4. 使用mapper接口的动态代理对象进行业务流程的编写
            /*
            //    4.1 测试where标签与if标签结合的动态SQL
            List<Employee> employees=employeeMapper.selectByNameOrEmail("test","wang");
            System.out.println(employees);
            */
            /*
            //   4.2 测试foreach标签动态生成SQL批量添加功能
            List<Employee> employeeList=new ArrayList<>();
            employeeList.add(new Employee(UUID.randomUUID().toString(),"test01","男","test01@email.com",1));
            employeeList.add(new Employee(UUID.randomUUID().toString(),"test02","女","test02@email.com",2));
            employeeList.add(new Employee(UUID.randomUUID().toString(),"test03","男","test03@email.com",3));
            System.out.println(employeeMapper.batchInsert(employeeList));
             */
            // 4.3 测试set标签与if标签结合动态生成需要要修改的列
            // Employee(id=01754065-9cf4-11eb-98f3-525400d5bdb5, name=test, gender=男, email=test@email.com, dId=2, department=null)
            Employee employee=new Employee("id=01754065-9cf4-11eb-98f3-525400d5bdb5","test","男","test@email.com",2);
            System.out.println(employeeMapper.updateById(employee));
        }finally {
            //5.关闭SqlSession
            sqlSession.close();
        }
    }
}
