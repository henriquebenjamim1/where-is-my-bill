package com.whereismybill.whereismybill.waiter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WaiterRepository extends JpaRepository<WaiterEntity, Long> {
}