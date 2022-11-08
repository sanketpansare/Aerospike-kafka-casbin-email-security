package com.restapi.kafka;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface Kafkaproducer {

    void send(@Topic String topic, String message);
    
}
