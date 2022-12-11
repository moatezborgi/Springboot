package com.example.gestionachat.Services;

import com.example.gestionachat.Entity.CatgeorieClient;
import com.example.gestionachat.Entity.Client;
import com.example.gestionachat.Entity.DetailFacture;
import com.example.gestionachat.Repository.ClientRepository;
import com.example.gestionachat.Repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class IClientServiceImp implements IClientService{
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    FactureRepository factureRepository;
    @Override
   public List<Client> retrieveAllClients(){return clientRepository.findAll();}

    @Override
    public Client addClient(Client c){return clientRepository.save(c);}
    @Override
    public Client updateClient(Client c){return clientRepository.save(c);}
   @Override
   public void deleteClient(Long id){ clientRepository.deleteById(id);}
    @Override
    public Client retrieveClient(Long id){return clientRepository.findById(id).orElse(null);}

    @Override
    public float getChiffreAffaireParCategorieClient(CatgeorieClient categorieClient, Date startDate, Date endDate) {
        float somme=0;
        List<Client> clients=clientRepository.findByCatgeorieClient(categorieClient);
        for (Client client : clients) {
            somme+=factureRepository.findByClientAndDateFactureBetween(client,startDate,endDate).getMontantFacture();
        }
            return somme;
    }


}
