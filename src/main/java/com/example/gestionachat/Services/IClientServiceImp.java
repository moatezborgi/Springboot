package com.example.gestionachat.Services;

import com.example.gestionachat.Entity.Client;
import com.example.gestionachat.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IClientServiceImp implements IClientService{
    @Autowired
    ClientRepository clientRepository;
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


}
