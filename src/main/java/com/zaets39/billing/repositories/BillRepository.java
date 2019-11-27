package com.zaets39.billing.repositories;

import com.zaets39.billing.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
   List<Bill> findAll();
}