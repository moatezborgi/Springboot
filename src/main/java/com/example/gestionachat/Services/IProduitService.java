package com.example.gestionachat.Services;

import com.example.gestionachat.Entity.Produit;

import java.util.List;

public interface IProduitService {
    public List<Produit> retrieveAllProduits();
    public  Produit retrieveProduit(Long id);
    public Produit addProduit(Produit p, Long idRayon, Long idStock);
    public void assignProduitToStock(Long idProduit, Long idStock);
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;
}
