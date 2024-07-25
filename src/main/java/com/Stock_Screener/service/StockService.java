package com.Stock_Screener.service;

import com.Stock_Screener.exception_handle.ResourceNotFoundException;
import com.Stock_Screener.model.Stock;
import com.Stock_Screener.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return stockRepository.findAll();
    }

    public Optional<Stock> getStockById(Integer id) {
        return Optional.ofNullable(stockRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Stock not found with id: " + id)
        ));
    }

    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public void deleteStock(Integer id) {
        stockRepository.deleteById(id);

    }

    public void deleteallStock(Stock stock) {
        stockRepository.delete(stock);

    }


}
