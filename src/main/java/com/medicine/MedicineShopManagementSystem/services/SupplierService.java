package com.medicine.MedicineShopManagementSystem.services;

import com.medicine.MedicineShopManagementSystem.entity.Supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> findAll();

    Supplier findById(int id);

    Supplier save(Supplier supplier);

    void deleteById(int id);

}
