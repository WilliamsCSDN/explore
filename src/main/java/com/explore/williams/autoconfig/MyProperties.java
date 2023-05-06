package com.explore.williams.autoconfig;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = MyProperties.PREFIX)
@Data
public class MyProperties {
    public static final String PREFIX = "com.williams";

    private String ip;

    private int port;
}
