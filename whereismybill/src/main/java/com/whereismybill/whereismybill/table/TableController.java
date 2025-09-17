package com.whereismybill.whereismybill.table;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class TableController {

    private final TableService service;

    public TableController(TableService service) {
        this.service = service;
    }

    @GetMapping
    public List<TableEntity> getAll() {
        return service.findAll();
    }

    @PostMapping
    public TableEntity create(@RequestBody TableEntity table) {
        return service.save(table);
    }

}
