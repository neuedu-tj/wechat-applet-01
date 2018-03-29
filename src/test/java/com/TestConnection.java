package com;

import com.entity.Category;
import com.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestConnection {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testConnection() throws SQLException {

//
//        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
//        DataSource ds = applicationContext.getBean(DataSource.class);
//        Connection conn = ds.getConnection();
//
//        ResultSet rs = conn.createStatement().executeQuery("select sysdate()");
//
//        if(rs.next()) System.out.println("result : " + rs.getString(1));
////
////        applicationContext.registerShutdownHook();
//
////        SqlSessionFactoryBean bean = applicationContext.getBean(SqlSessionFactoryBean.class);
////        SqlSessionFactory sql = applicationContext.getBean(SqlSessionFactory.class);
////        System.out.println(sql);

        List<Category> categories = categoryRepository.queryCategory();

        System.out.println(categories);

    }
}
