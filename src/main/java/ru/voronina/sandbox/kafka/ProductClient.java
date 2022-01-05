package ru.voronina.sandbox.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.MessageHeader;

@KafkaClient
public interface ProductClient {

    void sendProduct(@Topic String topic,
                     @KafkaKey String key,
                     @MessageHeader("Custom-Header") String customHeader,
                     String name);
}
