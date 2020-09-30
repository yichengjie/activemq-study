package com.yicj.study.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.activemq")
public class ActivemqProperties {
    private String brokerUrl;
    private String user;
    private String password;
    private String queueName;
    private String topicName;
}
