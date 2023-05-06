package com.explore.williams.autoconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBean {

    private Logger log = LoggerFactory.getLogger(MyBean.class);

    MyBean(){
        log.info("初始化 MyBean");
    }
}
