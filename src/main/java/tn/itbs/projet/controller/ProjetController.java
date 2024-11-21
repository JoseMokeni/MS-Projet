package tn.itbs.projet.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.itbs.projet.model.Projet;
import tn.itbs.projet.service.ProjetService;

import java.util.Optional;

@RestController
@RequestMapping(path = "/projet")
@AllArgsConstructor
public class ProjetController {

    private ProjetService projetService;

    @PostMapping(path = "/ajouter")
    public ResponseEntity<String> ajouter(@RequestBody Projet projet) {
        return projetService.ajouter(projet);
    }

    @DeleteMapping("/supprimer/{id}")
    public void supprimer(@PathVariable int id){

    }

    @GetMapping("/chercher/{id}")
    public Optional<Projet> chercher(@PathVariable int id){
        return projetService.chercher(id);
    }


}
