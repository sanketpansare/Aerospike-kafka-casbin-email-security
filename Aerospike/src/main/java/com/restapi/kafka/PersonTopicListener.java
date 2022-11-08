//package com.restapi.kafka;
//import io.micronaut.configuration.kafka.annotation.KafkaListener;
//import io.micronaut.configuration.kafka.annotation.OffsetReset;
//import io.micronaut.configuration.kafka.annotation.Topic;
//
//import org.apache.kafka.common.protocol.Message;
//
//@KafkaListener(offsetReset = OffsetReset.EARLIEST)
//public class PersonTopicListener {
//
//    @Topic(KafkaConstraints.PERSON_TOPIC_VALUE)
//    public void consumePersonNotification(Message message) {
//        System.out.print(message);
//
//    }
//}
