package com.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


//@PropertySource(value = "classpath:application.properties")
//@ConfigurationProperties(prefix = "spring")
@Configuration
@MapperScan("com.repository")
public class DataSourceConfiguration {

    @Value("${spring.datasource.url}")
    private String url;

//    @Value("${spring.datasource.username}")
    @Value("${spring.datasource.data-username}")
    private String username;

//    @Value("${spring.datasource.password}")
    @Value("${spring.datasource.data-password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    

    @Bean(value = "dataSource" )
    @Primary
    public DataSource dataSource() {

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setDefaultAutoCommit(false);
        return dataSource;
    }
    
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DataSourceConfiguration{");
        sb.append("url='").append(url).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", driverClassName='").append(driverClassName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
