package com.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


//@PropertySource(value = "classpath:application.properties")
//@ConfigurationProperties(prefix = "mybatis")


@Configuration
public class SessionFactoryConfiguration {

    @Value("${mybatis.config-location}")
    private String mybatisConfigFilePath;

    @Value("${mybatis.mapper-locations}")
    private String mapperPath;

    @Value("${mybatis.type-aliases-package}")
    private String entityPackage;


    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;


    @Bean("sqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactoryBean() throws Exception {
        

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(dataSource);

        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        
        return sqlSessionFactoryBean.getObject();
    }

  
}
