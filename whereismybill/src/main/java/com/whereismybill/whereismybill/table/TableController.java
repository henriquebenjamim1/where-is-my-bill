package com.whereismybill.whereismybill.table;

import com.whereismybill.whereismybill.product.ProductEntity;
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

    @GetMapping("/{id}")
    public TableEntity getTableById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public TableEntity create(@RequestBody TableEntity table) {
        return service.save(table);
    }

    @PutMapping("/{id}")
    public TableEntity updateTable(@PathVariable Long id, @RequestBody TableEntity table) {
        TableEntity existingTable = service.findById(id);
        existingTable.setNumber(table.getNumber());
        existingTable.setSeats(table.getSeats());
        return service.save(existingTable);
    }

    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable Long id) {
        service.delete(id);
    }



}
