package com.der.miutisourceb.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.der.miutisourceb.enums.DatabaseType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * springboot集成mybatis基本入口
 * 1、创建数据源
 * 2、创建SqlSessionFactory
 * @author K0790016
 **/
@Configuration
@MapperScan(basePackages = MybatisConfig.MAPPER_LOCATIONS, sqlSessionFactoryRef = "sessionFactory")
public class MybatisConfig {

    public static final String MAPPER_LOCATIONS = "com.der.miutisourceb.dao";

    @Autowired
    Environment environment;

    @Value("${master.datasource.driverClassName}")
    private String dbDriver;

    @Value("${master.datasource.url}")
    private String dbUrl;

    @Value("${master.datasource.username}")
    private String dbUsername;

    @Value("${master.datasource.password}")
    private String dbPassword;

    @Value("${second.datasource.url}")
    private String dbUrlSlave;

    @Value("${second.datasource.username}")
    private String dbUsernameSlave;

    @Value("${second.datasource.password}")
    private String dbPasswordSlave;

    /**
     * 创建 local环境 dataSource
     * @throws Exception
     */
//    @Bean(name="dataSourceFunctional")
    public DataSource dataSourceMaster() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    /**
     * 创建 回归环境 dataSource
     * @throws Exception
     */
//    @Bean(name="dataSourceRegression")
    public DataSource dataSourceSlave() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrlSlave);
        dataSource.setUsername(dbUsernameSlave);
        dataSource.setPassword(dbPasswordSlave);
        return dataSource;
    }

    /**
     * 1、创建动态数据源
     * @throws Exception
     * @Primary该注解表示在同一个接口有多个类可以注入的时候，默认选择哪个，而不是让@Autowired报错
     */
    @Bean(name="dynamicDataSource")
    @Primary
    public DynamicDataSource DataSource(){
        Map<Object, Object> targetDataSource = new HashMap<>();
        DataSource dataSourceMaster = dataSourceMaster();
        targetDataSource.put(DatabaseType.MASTER, dataSourceMaster);
        targetDataSource.put(DatabaseType.SLAVE, dataSourceSlave());
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(dataSourceMaster);

        return dataSource;
    }

    /**
     * 2、根据数据源创建SqlSessionFactory
     * @throws Exception
     */
    @Bean(name="sessionFactory")
    public SqlSessionFactory sessionFactory(@Qualifier("dynamicDataSource")DynamicDataSource dataSource) throws Exception{
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String location = environment.getProperty("mybatis.mapperLocations");
        System.out.println("=================");
        System.out.println(location);
        System.out.println("=================");
        sessionFactoryBean.setMapperLocations(resolver.getResources(location));    //*Mapper.xml位置
        return sessionFactoryBean.getObject();
    }
}
