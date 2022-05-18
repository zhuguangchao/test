package com.example.goods.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Auther: 朱广超
 * @Date: 2020/03/20/19:35
 * @package com.example.goods.dataSource
 * @Description:
 */
//@Configuration
//@MapperScan(basePackages = "com.example.goods.dao.mysql", sqlSessionFactoryRef = "mysqlSqlSessionFactory")
public class Mysql {
    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("mysqlSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("mysqlDataSource") DataSource mysqlDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mysqlDataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("mysqlSqlSessionFactory")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory mysqlSqlSessionFactory) {
        return new SqlSessionTemplate(mysqlSqlSessionFactory);
    }

    @Bean("mysqlTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("mysqlDataSource") DataSource mysqlDataSource) {
        return new DataSourceTransactionManager(mysqlDataSource);
    }

}
