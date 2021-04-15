import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.simple.mybatis.entity.Department;
import org.simple.mybatis.entity.Employee;
import org.simple.mybatis.mapper.DepartmentMapper;
import org.simple.mybatis.mapper.EmployeeMapper;
import org.simple.mybatis.util.SqlSessionFactoryUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(JUnit4.class)
public class DepartmentTest {

    @Test
    public void test() throws IOException {
        //1. 创建一个SQlSessionFactory连接工厂
        String resource="config/mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtil.createSqlSessionFactory(resource);
        //2. 创建SqlSession
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        try{
            //3. 根据SqlSession获取Mapper对象,该Mapper对象为动态代理对象
            DepartmentMapper departmentMapper=sqlSession.getMapper(DepartmentMapper.class);
            //4. 使用mapper接口的动态代理对象进行业务流程的编写
            Department department=departmentMapper.selectByIdWithEmployeeList(2);
            System.out.println(department);
        }finally {
            //5.关闭SqlSession
            sqlSession.close();
        }
    }
}
