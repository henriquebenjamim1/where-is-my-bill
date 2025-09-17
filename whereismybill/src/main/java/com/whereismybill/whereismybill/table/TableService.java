package com.whereismybill.whereismybill.table;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    private final TableRepository repository;

    public TableService(TableRepository repository) {
        this.repository = repository;
    }

    public List<TableEntity> findAll() {
        return repository.findAll();
    }

    public TableEntity save(TableEntity table) {
        return repository.save(table);
    }
}
