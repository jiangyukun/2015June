package me.jiangyu.june.app;

import me.jiangyu.june.web.filter.MyTestAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * by jiangyukun on 15/6/2.
 */
@EnableWebSecurity(debug = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").
                and()
                .formLogin().loginPage("/login").
                and().addFilterBefore(new MyTestAuthenticationFilter(), FilterSecurityInterceptor.class)
        ;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
