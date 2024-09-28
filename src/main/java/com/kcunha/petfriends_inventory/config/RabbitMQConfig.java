package com.kcunha.petfriends_inventory.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ configuration class for PetFriends_Inventory microservice.
 */
@Configuration
public class RabbitMQConfig {

    public static final String ORDER_CREATED_QUEUE = "order-created-queue";

    @Bean
    public Queue orderCreatedQueue() {
        return new Queue(ORDER_CREATED_QUEUE, true);
    }
}
