package com.yasin.paperlock.repository;

import com.yasin.paperlock.model.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill, Long> {
}
