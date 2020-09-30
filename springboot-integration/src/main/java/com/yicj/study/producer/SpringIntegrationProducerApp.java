package com.yicj.study.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:applicationContext-producer.xml")
public class SpringIntegrationProducerApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationProducerApp.class, args) ;
    }
}
