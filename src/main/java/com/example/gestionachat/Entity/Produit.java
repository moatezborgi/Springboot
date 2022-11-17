package com.example.gestionachat.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduit;
    private String codeProduit;
    private String libelleProduit;
    private float prixUnitaire;
    @OneToMany(mappedBy = "produit")
    private List<DetailFacture> detailFactures;
    @OneToOne
    public DetailProduit detailProduit;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Stock stock;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Rayon rayon;
    @OneToMany
    private List<Fournisseur> fournisseurs;
}
