package com.example.gestionachat.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetailFacture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetailFacture;
    private int qte;
    private float prixTotal;
    private int pourcentageRemise;
    private int montantRemise;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Facture facture;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Produit produit;
}
