package com.medicine.MedicineShopManagementSystem.services;

import com.medicine.MedicineShopManagementSystem.entity.Supplier;
import com.medicine.MedicineShopManagementSystem.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository theSupplierRepository) {
        this.supplierRepository = theSupplierRepository;
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findById(int id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);

        Supplier supplierObj = null;

        if (supplier.isPresent()) {
            supplierObj = supplier.get();
        }
        else {
            throw new RuntimeException("Supplier not found with id: " + id);
        }

        return supplierObj;
    }

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public void deleteById(int id) {
        supplierRepository.deleteById(id);
    }
}
