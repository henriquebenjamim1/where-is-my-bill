package com.whereismybill.whereismybill.waiter;

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

    @PostMapping
    public WaiterEntity create(@RequestBody WaiterEntity waiter) {
        return service.save(waiter);
    }
}
