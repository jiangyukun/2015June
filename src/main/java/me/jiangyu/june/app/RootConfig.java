package me.jiangyu.june.app;

import me.jiangyu.june.core.A;
import me.jiangyu.june.core.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * by jiangyukun on 15/6/3.
 */
@Configuration
@ComponentScan(basePackages = {"me.jiangyu.june"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = {
                "me.jiangyu.june.web.*", "me.jiangyu.june.app.*"
        })}
)
public class RootConfig {
    @Bean
    public B b() {
        return new B(new A());
    }
}
