package com.restapi.kafka;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class SendPersonNotification {
    @Inject
    Kafkaproducer kafkaProducer;



    public void sendPersonNotification(String message) {

        kafkaProducer.send(KafkaConstraints.EMPLOYEE_TOPIC_VALUE,  message);
    }
}
