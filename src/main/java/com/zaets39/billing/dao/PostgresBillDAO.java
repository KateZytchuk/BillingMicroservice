package com.zaets39.billing.dao;

import com.zaets39.billing.models.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postgres")
public class PostgresBillDAO implements BillingDAO<Bill> {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresBillDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Bill> getAll() {
        String query = "SELECT * FROM BILLS";
        return jdbcTemplate.query(query, (resultSet, i) ->
                new Bill(resultSet.getLong("id"),
                        resultSet.getBoolean("babySeat"),
                        resultSet.getBoolean("english"),
                        resultSet.getBoolean("conditioner"),
                        resultSet.getBoolean("pet"),
                        resultSet.getBoolean("courier"),
                        resultSet.getBoolean("nonSmoker"),
                        resultSet.getBoolean("silence"),
                        resultSet.getString("type"),
                        resultSet.getDouble("distance"),
                        resultSet.getString("paymentMode")));
    }

    @Override
    public double insertBill(Bill bill) {
        double amount =40+ bill.getDistance() * 7;
        long id = bill.getId();
        jdbcTemplate.update("update bills set amount = (?) where id = (?)", amount, id);
        return amount;
    }

    @Override
    public Bill add(Bill bill) {
        jdbcTemplate.update("insert into bills values (?,?,?,?,?,?,?,?,?,?,?,?)",
                bill.getId(), bill.getAmount(), bill.isBabySeat(), bill.isEnglishDriver(), bill.isConditioner(),
                bill.isPet(), bill.isCourier(), bill.isNonSmoker(), bill.isSilence(),
                bill.getCarType(), bill.getDistance(), bill.getPaymentMode());
        return bill;
    }
}
