package ru.voronina.sandbox.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;
import ru.voronina.sandbox.model.Product;
import ru.voronina.sandbox.service.ProductService;

import javax.validation.constraints.NotBlank;

@Controller("/product")
public class ProductController {

    private final ProductService productService;

    @Inject
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Post
    public Product create(@QueryValue @NotBlank String name) {
        return productService.create(name);
    }
}
