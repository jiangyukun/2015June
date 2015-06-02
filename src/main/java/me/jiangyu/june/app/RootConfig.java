package me.jiangyu.june.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Created by jiangyukun on 15/6/3.
 */
@Configuration
@ComponentScan(basePackages = {"me.jiangyu.june"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = "me.jiangyu.june.web.*")}
)
public class RootConfig {

    @Bean
    public String getString1() {
        return "xx";
    }
}
