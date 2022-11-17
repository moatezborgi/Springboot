package com.example.gestionachat.Services;

import com.example.gestionachat.Entity.Stock;

import java.util.List;

public interface IStockService {
    public List<Stock> retrieveAllStocks();
    public Stock addStock(Stock s);
    public Stock updateStock(Stock u);
    public Stock retrieveStock(Long id);
}
