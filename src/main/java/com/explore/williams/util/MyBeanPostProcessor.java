package com.explore.williams.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 查看Bean加载时间
 * @author Williams
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    private Logger log = LoggerFactory.getLogger(MyBeanPostProcessor.class);

    private Map<String, Long> hanlerMap = new ConcurrentHashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("start init {}", beanName);
        hanlerMap.put(beanName, System.currentTimeMillis());
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Long start = hanlerMap.get(beanName);
        if (start != null ){
            Long hanlerTime = System.currentTimeMillis() - start;
            if (hanlerTime > 0){
                log.info("{} init time: {}", beanName, hanlerTime);
            }
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);

    }
}
