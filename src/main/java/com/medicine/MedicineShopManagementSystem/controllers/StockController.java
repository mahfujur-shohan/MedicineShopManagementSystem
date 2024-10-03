package com.medicine.MedicineShopManagementSystem.controllers;

import com.medicine.MedicineShopManagementSystem.entity.Stock;
import com.medicine.MedicineShopManagementSystem.services.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StockController {

    private StockService stockService;

    public StockController(StockService theStockService) {
        this.stockService = theStockService;
    }

    @GetMapping("/stocks")
    public List<Stock> findAll() {
        return stockService.findAll();
    }

    @GetMapping("/stocks/{stockId}")
    public Stock findById(@PathVariable int stockId) {
        Stock stock = stockService.findById(stockId);

        if(stock == null) {
            throw new RuntimeException("Stock not found with id " + stockId);
        }

        return stock;
    }

    @PostMapping("/stocks")
    public Stock addStock(@RequestBody Stock stock) {

        stock.setDrugId(0);

        Stock savedStock = stockService.save(stock);

        return savedStock;
    }

    @PutMapping("/stocks")
    public Stock updateStock(@RequestBody Stock stock) {
        Stock savedStock = stockService.save(stock);

        return savedStock;
    }

    @DeleteMapping("/stocks/{stockId}")
    public String deleteById(@PathVariable int stockId) {
        Stock stock = stockService.findById(stockId);

        if(stock == null) {
            throw new RuntimeException("Stock not found with id " + stockId);
        }

        stockService.deleteById(stockId);

        return "Stock with id " + stockId + " deleted successfully";
    }

    // api for stock dashboard

    @GetMapping("/stocks/dashboard")
    public Map<String, Object> showDashboard() {
        Map<String, Object> map = new HashMap<>();

        map.put("getTotalStocks", stockService.getTotalStocks());

        return map;
    }

}
