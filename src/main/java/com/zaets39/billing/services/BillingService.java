package com.zaets39.billing.services;

import com.zaets39.billing.dao.BillingDAO;
import com.zaets39.billing.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {
    private final BillingDAO<Bill> billingDAO;

    @Autowired
    public  BillingService(@Qualifier("postgres") BillingDAO<Bill> billingDAO){
        this.billingDAO = billingDAO;
    }
    public List<Bill> getAllBills()
    {
        return billingDAO.getAll();
    }
    public double countAmount(Bill bill)
    {
       return billingDAO.insertBill(bill);
    }
}
