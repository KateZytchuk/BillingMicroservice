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
                new Bill(resultSet.getBoolean("babySeat"),
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
    public void insertBill(Bill bill) {
        double amount = bill.getDistance() * 33;
        jdbcTemplate.update("insert into bills(amount) values(?)", amount);
    }
}
