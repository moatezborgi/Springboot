package com.example.gestionachat.Repository;

import com.example.gestionachat.Entity.CatgeorieClient;
import com.example.gestionachat.Entity.Client;
import com.example.gestionachat.Entity.DetailFacture;
import com.example.gestionachat.Entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

 public List<Client> findByCatgeorieClient(CatgeorieClient cat);

}
