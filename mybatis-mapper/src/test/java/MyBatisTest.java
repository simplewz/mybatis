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
import java.util.UUID;

@RunWith(JUnit4.class)
public class MyBatisTest {

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
            //    4.1 测试查询
            Employee employee = employeeMapper.selectById("1");
            System.out.println(employee);
            */


            //    4.2 测试新增
            Employee employee=new Employee(null,"wangzhao","男","wangzhao@email.com");
            employeeMapper.insertWithGenerateKey(employee);
            System.out.println(employee);

            /*
            //    4.3 测试修改
            Employee employee=new Employee("d25b18ad-f6ba-4077-bc71-f721673ae2b7","wangzhaojun","女","wangzhaojun@email.com");
            employeeMapper.updateById(employee);
            */

            /*
            //    4.4 测试删除
            System.out.println(employeeMapper.deleteById("3"));
            */
        }finally {
            //5.关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testParam() throws IOException {
        //1. 创建一个SQlSessionFactory连接工厂
        String resource="config/mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtil.createSqlSessionFactory(resource);
        //2. 创建SqlSession
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        try{
            //3. 根据SqlSession获取Mapper对象,该Mapper对象为动态代理对象
            EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
            //4. 使用mapper接口的动态代理对象进行业务流程的编写


            List<Employee> employees=employeeMapper.selectByGenderAndName("男","wangzhao");
            System.out.println(employees);

            /*
            List<String> idList=new ArrayList<>();
            idList.add("6cda426d-9d1b-11eb-98f3-525400d5bdb5");
            idList.add("d25b18ad-f6ba-4077-bc71-f721673ae2b7");
            List<Employee> employees=employeeMapper.selectListByIdList(idList);
            System.out.println(employees);
            */
            /*
            String[] idArray=new String[]{"6cda426d-9d1b-11eb-98f3-525400d5bdb5","d25b18ad-f6ba-4077-bc71-f721673ae2b7"};
            List<Employee> employees=employeeMapper.selectListByIdArray(idArray);
            System.out.println(employees);
            */
        }finally {
            //5.关闭SqlSession
            sqlSession.close();
        }
    }
}
