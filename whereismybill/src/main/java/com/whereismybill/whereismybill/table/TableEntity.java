package com.whereismybill.whereismybill.table;

import com.whereismybill.whereismybill.order.OrderEntity;
import com.whereismybill.whereismybill.waiter.WaiterEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tables")
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer seats;

    @ManyToOne
    @JoinColumn(name = "waiter_id")
    private WaiterEntity waiter;

    @OneToMany(mappedBy = "table")
    private List<OrderEntity> orders;


    public TableEntity() {
    }

    public TableEntity(Integer number) {
        this.number = number;
    }

    public TableEntity(Integer number, Integer seats) {
        this.number = number;
        this.seats = seats;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public WaiterEntity getWaiter() {
        return waiter;
    }

    public void setWaiter(WaiterEntity waiter) {
        this.waiter = waiter;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }
}
