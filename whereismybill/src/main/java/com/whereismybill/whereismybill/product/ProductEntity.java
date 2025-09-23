package com.whereismybill.whereismybill.product;

import com.whereismybill.whereismybill.order.OrderEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class ProductEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private Boolean action = true;

    @ManyToMany(mappedBy = "products")
    private List<OrderEntity> orders;

    public ProductEntity() {
    }

    public ProductEntity(String name, String description, BigDecimal price, Boolean action) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.action = action;
    }

    public ProductEntity(BigDecimal price, String description, String name) {
        this.price = price;
        this.description = description;
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAction() {
        return action;
    }

    public void setAction(Boolean action) {
        this.action = action;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }
}
