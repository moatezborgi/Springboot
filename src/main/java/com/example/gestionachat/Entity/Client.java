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
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClient;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private CatgeorieClient catgeorieClient;
    @Enumerated(EnumType.STRING)
    private Profession profession;
    @OneToMany(mappedBy = "client")
    private List<Facture> factures;

}
