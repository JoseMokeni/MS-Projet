package tn.itbs.projet.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Utilisateur {
    private int id;

    private String nom;

    private String prenom;

    private String email;

    private String login;

    private String mdp;

    private List<Integer> listeIdProjets = new ArrayList<Integer>();


}
