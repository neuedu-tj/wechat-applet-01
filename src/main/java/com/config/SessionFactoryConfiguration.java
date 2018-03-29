package com.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@PropertySource(value = "classpath:application.properties")
@ConfigurationProperties(prefix = "mybatis")

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SessionFactoryConfiguration{");
        sb.append("mybatisConfigFilePath='").append(mybatisConfigFilePath).append('\'');
        sb.append(", mapperPath='").append(mapperPath).append('\'');
        sb.append(", entityPackage='").append(entityPackage).append('\'');
        sb.append(", dataSource=").append(dataSource);
        sb.append('}');
        return sb.toString();
    }
}
