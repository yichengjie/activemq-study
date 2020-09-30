package com.yicj.study.config;

import com.yicj.study.properties.ActivemqProperties;
import lombok.Data;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Data
@Configuration
@EnableConfigurationProperties(ActivemqProperties.class)
public class BeanConfig {

    @Autowired
    private ActivemqProperties activemqProperties ;

    @Bean(name = "testQueue")
    public Queue queue(){
        return new ActiveMQQueue("test-queue") ;
    }

    @Bean(name = "testTopic")
    public Topic topic(){
        return new ActiveMQTopic("test-topic") ;
    }

    @Bean
    public ConnectionFactory connectionFactory(){
        return new ActiveMQConnectionFactory(
                activemqProperties.getUser(), activemqProperties.getPassword(), activemqProperties.getBrokerUrl()) ;
    }

    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate(){
        return new JmsMessagingTemplate(connectionFactory()) ;
    }

    // 在queue模式中，对消息的监听需要对connectionFactory进行配置
    @Bean("queueListener")
    public JmsListenerContainerFactory<?> queueJmsListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory() ;
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(false);
        return factory ;
    }

    // 在topic模式中，对消息的监听需要对connectionFactory进行配置
    @Bean("topicListener")
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory() ;
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory ;
    }
}
