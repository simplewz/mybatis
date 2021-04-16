package org.simple.mybatis.util;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SqlSessionFactoryUtil {
    /**
     * 加载xml配置文件的方式配置SqlSessionFactory
     * @param resource  mybatis配置文件位置
     * @return
     * @throws IOException
     */
    public static SqlSessionFactory createSqlSessionFactory(String resource) throws IOException {
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        return sessionFactory;
    }

    /**
     * 以纯Java代码的方式配置SqlSessionFactory
     * @return
     */
    public static SqlSessionFactory createSqlSessionFactory(){
        //加载数据库配置文件
        Properties jdbcProperties=null;
        try {
            jdbcProperties=Resources.getResourceAsProperties("DataSource.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //使用加载的数据库配置文件创建一个池化的数据源
        PooledDataSource dataSource=new PooledDataSource();
        dataSource.setDriver(jdbcProperties.getProperty("jdbc.driver"));
        dataSource.setUrl(jdbcProperties.getProperty("jdbc.url"));
        dataSource.setUsername(jdbcProperties.getProperty("jdbc.username"));
        dataSource.setPassword(jdbcProperties.getProperty("jdbc.password"));

        //事物管理器配置
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        //环境配置
        Environment environment = new Environment("dev", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        //配置映射的SQL文件存放路径
        configuration.addMappers("org.simple.mybatis.mapper");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }
}
