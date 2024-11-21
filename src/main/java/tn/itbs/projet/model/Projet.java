package tn.itbs.projet.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Projet {
    @Id
    private int id;

    private String nom;

    private String description;

    private Date dateDebut;

    private Date dateFin;

    private int id_utilisateur;

    @Transient
    private Utilisateur utilisateur;

    @OneToMany(mappedBy =  "projet")
    private List<Tache> taches = new ArrayList<Tache>();


}
