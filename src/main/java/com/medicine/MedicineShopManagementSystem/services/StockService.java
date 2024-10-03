package com.medicine.MedicineShopManagementSystem.services;

import com.medicine.MedicineShopManagementSystem.entity.Stock;

import java.util.List;

public interface StockService {

    List<Stock> findAll();

    Stock findById(int id);

    Stock save(Stock stock);

    void deleteById(int id);

    long getTotalStocks();

}
