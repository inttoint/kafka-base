package ru.voronina.sandbox.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import ru.voronina.sandbox.model.Product;

@Requires(property = "kafka.consumers.enabled", value = StringUtils.TRUE, defaultValue = StringUtils.FALSE)
@KafkaClient
public interface ProductClient {

    void sendProduct(@Topic String topic, @KafkaKey String productId, Product product);
}
