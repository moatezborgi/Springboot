package com.example.gestionachat.Repository;

import com.example.gestionachat.Entity.Produit;
import com.example.gestionachat.Entity.Rayon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RayonRepository extends JpaRepository<Rayon,Long> {
}
