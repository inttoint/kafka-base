package ru.voronina.sandbox.service;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import ru.voronina.sandbox.kafka.ProductClient;
import ru.voronina.sandbox.model.Product;

import java.time.LocalDateTime;
import java.util.UUID;

@Singleton
@Slf4j
public class ProductService {

    private final String topic;
    private final ProductClient client;

    @Inject
    public ProductService(ProductClient client, @Value("${service.kafka.topics.product-created}") String topic) {
        this.client = client;
        this.topic = topic;
    }

    public Product create(String productName) {
        log.info("[Product] Create with name={}", productName);
        var product = new Product()
                .setId(UUID.randomUUID())
                .setName(productName)
                .setCreatedAt(LocalDateTime.now());

        client.sendProduct(topic, product.getId().toString(), product);
        return product;
    }
}
