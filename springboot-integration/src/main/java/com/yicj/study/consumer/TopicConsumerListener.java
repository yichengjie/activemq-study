package com.yicj.study.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TopicConsumerListener {

    // topic模式的消费者
    // containerFactory：在BeanConfig中配置的JmsListenerContainerFactory
    @JmsListener(destination = "test-topic", containerFactory = "topicListener")
    public void readActiveQueue(String message){
      log.info("topic接收到: {}", message);
    }
}
