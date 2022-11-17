package com.example.gestionachat.RestController;

import com.example.gestionachat.Entity.Client;
import com.example.gestionachat.Entity.Stock;
import com.example.gestionachat.Repository.StockRepository;
import com.example.gestionachat.Services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    IStockService iStockService;
    @GetMapping
    public List<Stock> retrieveAllStocks() {return iStockService.retrieveAllStocks();}
    @PostMapping
    public Stock addStock(@RequestBody Stock c) {
        return iStockService.addStock(c);
    }
    @PutMapping
    public Stock updateStock(@RequestBody Stock c) {
        return iStockService.updateStock(c);
    }

    @GetMapping("/{idStock}")
    public Stock retrieveContrat(@PathVariable long idStock) {
        return iStockService.retrieveStock(idStock);
    }
}
