package com.explore.williams.autoconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(MyBean.class)
@EnableConfigurationProperties(MyProperties.class)
@ConditionalOnProperty("com.williams.switch")
public class MyAutoConfiguration {

    private Logger log = LoggerFactory.getLogger(MyAutoConfiguration.class);

    @Autowired
    MyProperties myProperties;

    @ConditionalOnMissingBean(MyBean.class)
    @Bean
    public MyBean first(){
        String ip = myProperties.getIp();
        int port = myProperties.getPort();
        log.info("ip：{}, 端口号：{}", ip, port);
        return new MyBean();
    }
}
