import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.simple.mybatis.entity.Employee;
import org.simple.mybatis.mapper.EmployeeMapper;
import org.simple.mybatis.util.SqlSessionFactoryUtil;

import java.io.IOException;

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
            Employee employee = employeeMapper.selectById("1");
            System.out.println(employee);
        }finally {
            //5.关闭SqlSession
            sqlSession.close();
        }
    }
}
