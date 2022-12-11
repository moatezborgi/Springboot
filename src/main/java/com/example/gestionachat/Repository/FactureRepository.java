package com.example.gestionachat.Repository;

 import com.example.gestionachat.Entity.Client;
 import com.example.gestionachat.Entity.DetailFacture;
 import com.example.gestionachat.Entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

 import java.util.Date;
 import java.util.List;

public interface FactureRepository extends JpaRepository<Facture,Long> {
  public List<Facture> findFacturesByClient(Client c);
  public Facture findByClientAndDateFactureBetween(Client c, Date datedebut, Date datefin);
}
