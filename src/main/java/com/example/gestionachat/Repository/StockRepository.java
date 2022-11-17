package com.example.gestionachat.Repository;

import com.example.gestionachat.Entity.Client;
import com.example.gestionachat.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
