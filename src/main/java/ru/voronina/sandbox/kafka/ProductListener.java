package ru.voronina.sandbox.kafka;

import io.micronaut.configuration.kafka.annotation.*;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import io.micronaut.messaging.Acknowledgement;
import lombok.extern.slf4j.Slf4j;
import ru.voronina.sandbox.model.Product;

@Requires(property = "kafka.producers.enabled", value = StringUtils.TRUE, defaultValue = StringUtils.FALSE)
@KafkaListener(
        groupId = "products",
        offsetReset = OffsetReset.EARLIEST,
        offsetStrategy = OffsetStrategy.DISABLED
)
@Slf4j
public class ProductListener {

    @Topic("${service.kafka.topics.product-created}")
    void receive(@KafkaKey String productId, Product product, Acknowledgement acknowledgement) {
        log.info("[KAFKA] Receive msg: [product={}] with key={}", product, productId);

        // some action

        acknowledgement.ack();
    }
}
