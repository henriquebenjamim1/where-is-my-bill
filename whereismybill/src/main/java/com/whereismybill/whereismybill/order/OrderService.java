package com.whereismybill.whereismybill.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<OrderEntity> findAll() {
        return repository.findAll();
    }

    public OrderEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public OrderEntity save(OrderEntity order) {
        return repository.save(order);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
