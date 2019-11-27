package com.zaets39.billing.services;

import com.zaets39.billing.constants.Fares;
import com.zaets39.billing.models.Bill;
import com.zaets39.billing.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {
    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public double countAmount(Bill bill) {
        Fares fares = new Fares();
        return (fares.MIN_PRICE + fares.MAX_PRICE) / 2;
    }
}
