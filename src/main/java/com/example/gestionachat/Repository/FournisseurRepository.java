package com.example.gestionachat.Repository;

import com.example.gestionachat.Entity.Client;
import com.example.gestionachat.Entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
