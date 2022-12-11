package com.example.gestionachat.Repository;

import com.example.gestionachat.Entity.Client;
import com.example.gestionachat.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock,Long> {
    @Query("SELECT e FROM Stock e WHERE e.qteStock <=e.qteMin")
    List<Stock> findByQteStockMin();
}
