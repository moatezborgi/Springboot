package com.example.gestionachat.RestController;

import com.example.gestionachat.Entity.Client;
import com.example.gestionachat.Entity.Facture;
import com.example.gestionachat.Services.IFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facture")
public class FactureConroller {

    @Autowired
    IFactureService iFactureService;
    @GetMapping
    public List<Facture> retrieveAllFacture() {return iFactureService.retrieveAllFactures();}

    @GetMapping("/{idfacture}")
    public Facture retrieveFacture(@PathVariable long idfacture) {
        return iFactureService.retrieveFacture(idfacture);
    }

    @PutMapping
    public void cancelFacture(@PathVariable long id) {
          iFactureService.cancelFacture(id);
    }
    @GetMapping("getbyclient/{idClient}")
    public List<Facture> getFacturesByClient(@PathVariable long idClient) {
        return iFactureService.getFacturesByClient(idClient);
    }

    @PostMapping("{idClient}")
    public Facture addFacture(@RequestBody Facture f, @PathVariable Long idClient){return iFactureService.addFacture(f,idClient);}
}
