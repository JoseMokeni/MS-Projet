package tn.itbs.projet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Tache {
    @Id
    private int id;

    private String titre;

    private String description;

    private Date dateEcheance;

    private String status;

    @ManyToOne
    @JoinColumn(name =  "id_projet")
    private Projet projet;

    @OneToMany(mappedBy =  "tache")
    private ArrayList<Etiquette> etiquettes = new ArrayList<Etiquette>();

}
