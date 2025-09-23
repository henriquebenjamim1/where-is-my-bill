package com.whereismybill.whereismybill.waiter;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaiterService {

    private final WaiterRepository repository;

    public WaiterService(WaiterRepository repository) {
        this.repository = repository;
    }

    public List<WaiterEntity> findAll() {
        return repository.findAll();
    }

    public WaiterEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Waiter not found with id: " + id));
    }

    public WaiterEntity save(WaiterEntity waiter) {
        return repository.save(waiter);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
