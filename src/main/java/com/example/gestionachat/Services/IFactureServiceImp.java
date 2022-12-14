package com.example.gestionachat.Services;

import com.example.gestionachat.Entity.Client;
import com.example.gestionachat.Entity.DetailFacture;
import com.example.gestionachat.Entity.Facture;
import com.example.gestionachat.Repository.ClientRepository;
import com.example.gestionachat.Repository.DetailFactureRepository;
import com.example.gestionachat.Repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IFactureServiceImp implements IFactureService{

     @Autowired
    FactureRepository factureRepository;
    @Autowired
    IClientService iClientService;
    @Autowired
    DetailFactureRepository detailFactureRepository;
    @Override
    public List<Facture> retrieveAllFactures(){return  factureRepository.findAll();}
    @Override
    public void cancelFacture(Long id){
        Facture f=factureRepository.findById(id).orElse(null);
        if(f!=null && !f.isActive())
        {
            f.setActive(false);

        }


    }
    @Override
   public Facture retrieveFacture(Long id){
        return factureRepository.findById(id).orElse(null);
   }

@Override
public List<Facture> getFacturesByClient(Long idClient){
    Client c= iClientService.retrieveClient(idClient);
        return factureRepository.findFacturesByClient(c);

}

@Override
public Facture addFacture(Facture f, Long idClient)
{
    float somme=0;
    float montantremise=0;
    List<DetailFacture> df =detailFactureRepository.findDetailFactureByFacture(f);
    for (DetailFacture detailFacture : df) {
        somme+=detailFacture.getPrixTotal();
        montantremise+=detailFacture.getMontantRemise();
    }
    Client c=iClientService.retrieveClient(idClient);
    f.setClient(c);
    f.setMontantFacture(somme);
    f.setMontantRemise(montantremise);
    return factureRepository.save(f);
}


}
