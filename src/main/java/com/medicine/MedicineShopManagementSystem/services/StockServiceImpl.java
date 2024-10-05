package com.medicine.MedicineShopManagementSystem.services;

import com.medicine.MedicineShopManagementSystem.entity.Stock;
import com.medicine.MedicineShopManagementSystem.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository theStockRepository) {
        this.stockRepository = theStockRepository;
    }


    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public Stock findById(int id) {
        Optional<Stock> stock = stockRepository.findById(id);

        Stock stockObj = null;

        if (stock.isPresent()) {
            stockObj = stock.get();
        }
        else {
            throw new RuntimeException("Stock not found with id " + id);
        }

        return stockObj;
    }

    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public void deleteById(int id) {
        stockRepository.deleteById(id);
    }

    @Override
    public long getTotalStocks() {
        return stockRepository.count();
    }

    @Override
    public int getExpiredDrugs() {
        LocalDate currentDate = LocalDate.now();

        List<Stock> allStocks = stockRepository.findAll();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int expiredDrugs = 0;

        for (Stock stock : allStocks) {
            LocalDate expiredDate = LocalDate.parse(stock.getExpiredDate(), formatter);

            if (expiredDate.isBefore(currentDate)) {
                expiredDrugs++;
            }
        }

        return expiredDrugs;
    }
}
