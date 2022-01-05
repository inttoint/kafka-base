package ru.voronina.sandbox.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class Product {

    private UUID id;
    private String name;
    private LocalDateTime createdAt;
}
