package com.whereismybill.whereismybill.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductEntity> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ProductEntity create(@RequestBody ProductEntity product) {
        return service.save(product);
    }
}
