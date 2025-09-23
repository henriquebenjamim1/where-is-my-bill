package com.whereismybill.whereismybill.order;

import org.hibernate.query.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrderEntity> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public  OrderEntity getOrderById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public OrderEntity createOrder(@RequestBody OrderEntity order) {
        return service.save(order);
    }

    @PutMapping("/{id}")
    public OrderEntity updateOrder(@PathVariable Long id, @RequestBody OrderEntity order) {
        OrderEntity existing = service.findById(id);
        existing.setTable(order.getTable());
        existing.setProducts(order.getProducts());
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        service.delete(id);
    }
}
