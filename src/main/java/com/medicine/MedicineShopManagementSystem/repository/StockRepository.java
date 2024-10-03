package com.medicine.MedicineShopManagementSystem.repository;

import com.medicine.MedicineShopManagementSystem.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {


}
