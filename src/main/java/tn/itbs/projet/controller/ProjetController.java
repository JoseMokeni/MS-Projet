package tn.itbs.projet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.itbs.projet.model.Projet;
import tn.itbs.projet.service.ProjetService;

@RestController
@RequestMapping(path = "/projet")
public class ProjetController {

    private ProjetService projetService;

    @PostMapping(path = "/ajouter")
    public ResponseEntity<String> ajouter(@RequestBody Projet projet) {
        return projetService.ajouter(projet);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable int id){

    }


}
