package ru.voronina.sandbox.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.OffsetStrategy;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import io.micronaut.messaging.Acknowledgement;

@Requires(property = "kafka.producers.enabled", value = StringUtils.TRUE, defaultValue = StringUtils.FALSE)
@KafkaListener(
        groupId = "products",
        offsetReset = OffsetReset.EARLIEST,
        offsetStrategy = OffsetStrategy.DISABLED
)
public class ProductListener {

    @Topic("${service.kafka.topics.product}")
    void receive(String name, Acknowledgement acknowledgement) {
        // some action
        acknowledgement.ack();
    }
}
