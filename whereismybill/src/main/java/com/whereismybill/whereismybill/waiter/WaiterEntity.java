package com.whereismybill.whereismybill.waiter;

import com.whereismybill.whereismybill.table.TableEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class WaiterEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "waiter")
    private List<TableEntity> tables;

    public WaiterEntity() {
    }

    public WaiterEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public List<TableEntity> getTables() {
        return tables;
    }

    public void setTables(List<TableEntity> tables) {
        this.tables = tables;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
