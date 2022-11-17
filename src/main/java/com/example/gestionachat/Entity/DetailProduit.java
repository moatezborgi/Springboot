package com.example.gestionachat.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DetailProduit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetailProduit;
    private Date dateCreation;
    private Date dateDerniereModification;
    @Enumerated(EnumType.STRING)
    private CategorieProduit categorieProduit;
    @OneToOne(mappedBy = "detailProduit")
    public Produit produit;
}
