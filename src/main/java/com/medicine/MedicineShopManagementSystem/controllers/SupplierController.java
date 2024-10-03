package com.medicine.MedicineShopManagementSystem.controllers;

import com.medicine.MedicineShopManagementSystem.entity.Supplier;
import com.medicine.MedicineShopManagementSystem.services.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierController {

    private SupplierService supplierService;

    public SupplierController(SupplierService theSupplierService) {
        this.supplierService = theSupplierService;
    }

    @GetMapping("/suppliers")
    public List<Supplier> findAl() {
        return supplierService.findAll();
    }

    @GetMapping("/suppliers/{supplierId}")
    public Supplier findById(@PathVariable int supplierId) {
        Supplier supplier = supplierService.findById(supplierId);

        if (supplier == null) {
            throw new RuntimeException("Supplier with id " + supplierId + " not found");
        }

        return supplier;
    }

    @PostMapping("/suppliers")
    public Supplier addSupplier(@RequestBody Supplier supplier) {

        supplier.setSupplierId(0);

        Supplier theSupplier = supplierService.save(supplier);

        return theSupplier;

    }

    @PutMapping("/suppliers")
    public Supplier updateSupplier(@RequestBody Supplier supplier) {
        Supplier theSupplier = supplierService.save(supplier);

        return theSupplier;
    }

    @DeleteMapping("/suppliers/{supplierId}")
    public String deleteById(@PathVariable int supplierId) {
        Supplier supplier = supplierService.findById(supplierId);

        if (supplier == null) {
            throw new RuntimeException("Supplier with id " + supplierId + " not found");
        }

        supplierService.deleteById(supplierId);

        return "Supplier with id " + supplierId + " deleted sucessfully";
    }

}
