package com.example.gestionachat.Repository;

 import com.example.gestionachat.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
