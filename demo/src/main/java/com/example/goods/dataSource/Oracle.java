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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Auther: 朱广超
 * @Date: 2020/03/20/19:35
 * @package com.example.goods.dataSource
 * @Description:
 */
@Configuration
@MapperScan(basePackages = "com.example.goods.dao.oracle", sqlSessionFactoryRef = "oracleSqlSessionFactory")
public class Oracle {
    @Bean(name = "oracleDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("oracleSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("oracleDataSource") DataSource oracleDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(oracleDataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("oracleSqlSessionFactory")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("oracleSqlSessionFactory") SqlSessionFactory oracleSqlSessionFactory) {
        return new SqlSessionTemplate(oracleSqlSessionFactory);
    }

    @Bean("oracleTransactionManager")
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("oracleDataSource") DataSource oracleDataSource) {
        return new DataSourceTransactionManager(oracleDataSource);
    }
}
