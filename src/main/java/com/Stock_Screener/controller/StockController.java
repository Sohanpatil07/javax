package com.Stock_Screener.controller;
import com.Stock_Screener.model.Stock;
import com.Stock_Screener.service.StockService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Controller")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getAllStocks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return stockService.getAllStocks(page, size);
    }

    @GetMapping("/{id}")
    public Optional<Stock> getStockById(@PathVariable Integer id) {
        return stockService.getStockById(id);

    }

    @PostMapping
    public Stock createStock(@Valid @RequestBody Stock stock, BindingResult result) {
        if (result.hasErrors()) {
            // Handle validation errors
            throw new IllegalArgumentException(result.getFieldError().getDefaultMessage());
        }
        return stockService.saveStock(stock);
    }



    @PutMapping("/{id}")
    public Stock updateStock( @Valid @PathVariable Long id, @RequestBody Stock stock) {
        stock.setId(id);
        return stockService.saveStock(stock);
    }

    @DeleteMapping("/{id}")
    public String deleteStock(@PathVariable Integer id) {
        stockService.deleteStock(id);
         return "deleted";
    }
    @DeleteMapping
    public String deleteallStock(@RequestBody Stock stock) {
        stockService.deleteallStock(stock);
        return "all stocks are deleted";
    }
}
