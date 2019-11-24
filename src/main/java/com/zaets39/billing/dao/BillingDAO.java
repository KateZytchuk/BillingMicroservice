package com.zaets39.billing.dao;

import com.zaets39.billing.models.Bill;

import java.util.List;

public interface BillingDAO<T> {
    List<T> getall();
    void insertBill(Bill bill);
}
