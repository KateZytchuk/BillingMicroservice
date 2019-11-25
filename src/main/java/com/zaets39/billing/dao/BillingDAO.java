package com.zaets39.billing.dao;

import com.zaets39.billing.models.Bill;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BillingDAO<T> {
    List<T> getAll();
    double insertBill(Bill bill);
    Bill add(Bill bill);
}
