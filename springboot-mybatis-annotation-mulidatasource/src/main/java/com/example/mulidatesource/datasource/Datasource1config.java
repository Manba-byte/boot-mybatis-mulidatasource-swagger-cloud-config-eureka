package com.example.mulidatesource.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author wh
 * @description 数据源1对应test1数据库
 * @date 2019/4/18
 */
@Configuration
@MapperScan(basePackages = "com.example.mulidatesource.mapper.test1" , sqlSessionTemplateRef = "test1SqlSessionTemplate")
//basePackages扫描的包:对应mapper interface路径,sqlSessionTemplateRef根据注入的@Bean SqlSessionTemplate name保持一致
public class Datasource1config {

    @Bean(name="test1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    // @Primary //自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "test1SqlSessionFactory")
    //参数中这个@Qualifier注解表示,根据name=test1DataSource去自动装配
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //指定mybatis核心配置文件
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis-config.xml")[0]);
        //指定对应的mapper.xml的位置
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/test1/*.xml"));

        return bean.getObject();
    }

    @Bean(name = "test1TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test1DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "test1SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory)throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
