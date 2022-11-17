package com.example.gestionachat.Services;

import com.example.gestionachat.Entity.Fournisseur;
import com.example.gestionachat.Entity.Produit;
import com.example.gestionachat.Entity.Rayon;
import com.example.gestionachat.Entity.Stock;
import com.example.gestionachat.Repository.FournisseurRepository;
import com.example.gestionachat.Repository.ProduitRepository;
import com.example.gestionachat.Repository.RayonRepository;
import com.example.gestionachat.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProduitServiceImp implements IProduitService{
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    RayonRepository rayonRepository;
    @Autowired
    StockRepository stockRepository;
    @Autowired
    IStockService iStockService;
    @Autowired
    FournisseurRepository fournisseurRepository;
        @Override
     public List<Produit> retrieveAllProduits(){return produitRepository.findAll();}
    @Override
    public  Produit retrieveProduit(Long id){return produitRepository.findById(id).orElse(null);}
    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock){
        Rayon r=rayonRepository.findById(idRayon).orElse(null);
        Stock s=stockRepository.findById(idStock).orElse(null);
        if(r!=null && s!=null)
        {
            p.setRayon(r);
            p.setStock(s);

        }
        Produit produit=produitRepository.save(p);

        return produit;
    }
    @Override
    public void assignProduitToStock(Long idProduit, Long idStock)
    {
        Produit produit=retrieveProduit(idProduit);
        if ( produit!= null && iStockService.retrieveStock(idStock)!=null){
            produit.setStock(iStockService.retrieveStock(idStock));
            produitRepository.save(produit);}
    }
    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId)
    {
        Fournisseur f=fournisseurRepository.findById(fournisseurId).orElse(null);
        if(f!=null && retrieveProduit(produitId)!=null)
        {
            retrieveProduit(produitId).getFournisseurs().add(f);

        }
    }

}
