package me.jiangyu.june.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * jiangyukun on 2015/6/3.
 */
@Component
public class MySpringBeanClassPrint implements BeanPostProcessor {
    Logger logger = LoggerFactory.getLogger(MySpringBeanClassPrint.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.debug(bean.getClass().getName() + " [" + beanName + "]");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
