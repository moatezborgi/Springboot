package com.example.gestionachat.RestController;

import com.example.gestionachat.Entity.Client;
import com.example.gestionachat.Entity.Facture;
import com.example.gestionachat.Entity.Produit;
import com.example.gestionachat.Services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Produit")
public class ProduitController {
    @Autowired
    IProduitService iProduitService;
    @GetMapping
    public List<Produit> retrieveAllProduit() {return iProduitService.retrieveAllProduits();}

    @PostMapping("/{idRayon}/{idStock}")
    public Produit addProduit(@RequestBody Produit p, @PathVariable long idRayon,long idStock) {
        return iProduitService.addProduit(p, idRayon,idStock);
    }
    @GetMapping("/{idProduit}")
    public Produit retrieveContrat(@PathVariable long idProduit) {
        return iProduitService.retrieveProduit(idProduit);
    }
     @PostMapping("/{idProduit}/{idStock}")
    public void  assignProduitToStock(@PathVariable long idProduit,@PathVariable long idStock) {
         iProduitService.assignProduitToStock(idProduit, idStock);
    }
     @PostMapping("assignFournisseurToProduit/{fournisseurId}/{produitId}")
    public void  assignFournisseurToProduit(@PathVariable long fournisseurId,@PathVariable long produitId) {
        iProduitService.assignFournisseurToProduit(fournisseurId, produitId);
    }

}
