package com.example.gestionachat.Services;

import com.example.gestionachat.Entity.Client;

import java.util.List;

public interface IClientService {
    public List<Client> retrieveAllClients();
    public Client addClient(Client c);
    public Client updateClient(Client c);
    public void deleteClient(Long id);
    public Client retrieveClient(Long id);
}
