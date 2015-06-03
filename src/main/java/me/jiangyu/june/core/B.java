package me.jiangyu.june.core;

import org.springframework.stereotype.Component;

/**
 * jiangyukun on 2015/6/3.
 */
@Component
public class B {
    public B() {
    }

    public B(A a) {
        System.out.println("b");
    }
}
