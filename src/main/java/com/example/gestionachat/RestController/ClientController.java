package com.example.gestionachat.RestController;

import com.example.gestionachat.Entity.Client;
import com.example.gestionachat.Services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    IClientService iClientService;

    @GetMapping
    public List<Client> retrieveAllClients() {return iClientService.retrieveAllClients();}

    @PostMapping
    public Client addClient(@RequestBody Client c) {
        return iClientService.addClient(c);
    }

    @PutMapping
    public Client updateClient(@RequestBody Client c) {
        return iClientService.updateClient(c);
    }

    @GetMapping("/{idClient}")
    public Client retrieveContrat(@PathVariable long idClient) {
        return iClientService.retrieveClient(idClient);
    }

    @DeleteMapping("/{idClient}")
    public void removeClient(@PathVariable long idClient) {
        iClientService.deleteClient(idClient);
    }



}
