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
    public void testFirstCache() throws IOException {
        //1. 创建一个SQlSessionFactory连接工厂
        String resource="config/mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtil.createSqlSessionFactory(resource);
        //2. 创建SqlSession
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        try{
            //3. 根据SqlSession获取Mapper对象,该Mapper对象为动态代理对象
            EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
            //4. 使用mapper接口的动态代理对象进行业务流程的编写


            //  测试mybatis的一级缓存
            //  在同一次会话中,查询同一个id的Employee记录，控制台只打印一次查询日志,且 employee1==employee2 输出为true
            Employee employee1=employeeMapper.selectById("d25b18ad-f6ba-4077-bc71-f721673ae2b7");
            System.out.println(employee1);

            Employee employee2=employeeMapper.selectById("d25b18ad-f6ba-4077-bc71-f721673ae2b7");
            System.out.println(employee2);

            System.out.println(employee1==employee2);
        }finally {
            //5.关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSecondCache() throws IOException {
        //1. 创建一个SQlSessionFactory连接工厂
        String resource="config/mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtil.createSqlSessionFactory(resource);
        //2. 创建SqlSession
        SqlSession sqlSession1=sqlSessionFactory.openSession(true);
        SqlSession sqlSession2=sqlSessionFactory.openSession(true);

        try{
            //3. 根据SqlSession获取Mapper对象,该Mapper对象为动态代理对象
            EmployeeMapper employeeMapper1=sqlSession1.getMapper(EmployeeMapper.class);
            EmployeeMapper employeeMapper2=sqlSession2.getMapper(EmployeeMapper.class);
            //4. 使用mapper接口的动态代理对象进行业务流程的编写


            //  测试mybatis的二级级缓存
            Employee employee1=employeeMapper1.selectById("d25b18ad-f6ba-4077-bc71-f721673ae2b7");
            System.out.println(employee1);
            sqlSession1.close();

            Employee employee2=employeeMapper2.selectById("d25b18ad-f6ba-4077-bc71-f721673ae2b7");
            System.out.println(employee2);
            sqlSession2.close();

        }finally {
            //5.关闭SqlSession

        }
    }
}
