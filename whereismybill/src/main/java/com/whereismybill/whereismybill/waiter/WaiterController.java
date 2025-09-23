package com.whereismybill.whereismybill.waiter;

import com.whereismybill.whereismybill.order.OrderEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waiters")
public class WaiterController {

    private final WaiterService service;

    public WaiterController(WaiterService service) {
        this.service = service;
    }

    @GetMapping
    public List<WaiterEntity> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public WaiterEntity getOrderById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public WaiterEntity create(@RequestBody WaiterEntity waiter) {
        return service.save(waiter);
    }

    @PutMapping("/{id}")
    public WaiterEntity updateWaiter(@PathVariable Long id, @RequestBody WaiterEntity waiter) {
        WaiterEntity existingWaiter = service.findById(id);
        existingWaiter.setName(waiter.getName());
        existingWaiter.setEmail(waiter.getEmail());
        return service.save(existingWaiter);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        service.delete(id);
    }
}
