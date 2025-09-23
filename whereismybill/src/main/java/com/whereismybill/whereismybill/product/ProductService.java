package com.whereismybill.whereismybill.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductEntity> findAll() {
        return repository.findAll();
    }

    public ProductEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public ProductEntity save(ProductEntity product) {
        return repository.save(product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
