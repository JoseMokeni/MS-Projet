package tn.itbs.projet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Etiquette {
    @Id
    private int id;

    private String libelle;

    @ManyToOne
    @JoinColumn(name = "id_tache")
    private Tache tache;
}
