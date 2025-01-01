package com.ms.email.configs;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queue}") // ele pegará o valor atribuido no application properties e colocará no queue
    private String queue;

    @Bean
    public Queue queue(){
        return new Queue(queue,true);
    }

    // argumento true: Uma fila durável sobrevive a reinicializações
    // do servidor RabbitMQ, garantindo que as mensagens não sejam perdidas.

    @Bean
    public Jackson2JsonMessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}

// Lembrete 1:
// Quando uma aplicação Spring Boot sobe, o Spring Framework automaticamente
// detecta todas as classes anotadas com @Configuration
