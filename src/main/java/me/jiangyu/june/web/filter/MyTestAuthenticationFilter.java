package me.jiangyu.june.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * jiangyukun on 2015/5/25.
 */
@Component
public class MyTestAuthenticationFilter extends OncePerRequestFilter {
    Logger logger = LoggerFactory.getLogger(MyTestAuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Authentication authentication = new UsernamePasswordAuthenticationToken("test", "vvvv",
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
        authentication.setAuthenticated(false);
        logger.debug(Boolean.toString(authentication.isAuthenticated()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
