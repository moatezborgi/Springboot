package com.example.gestionachat.Services;

import com.example.gestionachat.Entity.Stock;
import com.example.gestionachat.Repository.ClientRepository;
import com.example.gestionachat.Repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j

public class IStockServiceImp implements IStockService {
    @Autowired
    StockRepository stockRepository;
    @Override
   public List<Stock> retrieveAllStocks(){return stockRepository.findAll();}
    @Override
    public Stock addStock(Stock s){return stockRepository.save(s);}
    @Override
    public Stock updateStock(Stock u){return stockRepository.save(u);}
    @Override
    public Stock retrieveStock(Long id){return stockRepository.findById(id).orElse(null);}
    @Override
    @Scheduled(fixedRate = 1000)
    public String retrieveStatusStock() {
        List<Stock> stocks=stockRepository.findByQteStockMin();
        stocks.stream().forEach(
                (stock -> {
                    log.info(stock.getLibelleStock()+" est en rupture");
                })
        );
        return null;
    }

}
