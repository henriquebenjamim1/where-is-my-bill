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

    @GetMapping("/{id}")
    public ProductEntity getProductById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public ProductEntity create(@RequestBody ProductEntity product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public ProductEntity update(@PathVariable Long id, @RequestBody ProductEntity product) {
        ProductEntity existingProduct = service.findById(id);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return service.save(existingProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.delete(id);
    }
}
