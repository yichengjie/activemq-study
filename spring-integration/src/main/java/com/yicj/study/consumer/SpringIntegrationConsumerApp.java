package com.yicj.study.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:applicationContext-producer.xml")
public class SpringIntegrationConsumerApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationConsumerApp.class, args) ;
    }
}
