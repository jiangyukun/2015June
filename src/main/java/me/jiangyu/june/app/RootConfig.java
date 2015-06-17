package me.jiangyu.june.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * by jiangyukun on 15/6/3.
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = {"me.jiangyu.june"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = {
                "me.jiangyu.june.web.*", "me.jiangyu.june.app.*"
        })}
)
public class RootConfig {
    @Bean
    public DataSource dataSource() {
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        return lookup.getDataSource("2015June");
    }

    @Bean
    public DefaultPersistenceUnitManager persistenceUnitManager() {
        DefaultPersistenceUnitManager persistenceUnitManager = new DefaultPersistenceUnitManager();
        persistenceUnitManager.setPersistenceXmlLocation("classpath:persistence.xml");
        Map<String, DataSource> dataSources = new HashMap<>();
        dataSources.put("dataSource", dataSource());
        persistenceUnitManager.setDataSources(dataSources);
        persistenceUnitManager.setDefaultDataSource(dataSource());
        return persistenceUnitManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPersistenceUnitManager(persistenceUnitManager());
        entityManagerFactory.setPersistenceUnitName("Unit1");
        entityManagerFactory.setPackagesToScan("me.jiangyu.june.domain");

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(false);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        return entityManagerFactory;
    }

    @Bean
    public PlatformTransactionManager jpaTransactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }
}
