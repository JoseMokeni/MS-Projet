package tn.itbs.projet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.itbs.projet.model.Projet;
import tn.itbs.projet.repository.ProjetRepository;

import java.util.Optional;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepository projetRepository;
    /**
     * @param projet
     * @return ResponseEntity
     */
    public ResponseEntity<String> ajouter(Projet projet) {
        projetRepository.findById(projet.getId())
                .ifPresentOrElse(p -> {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Projet déjà existant");
                }, () -> projetRepository.save(projet)
                );
        return ResponseEntity.accepted().body("Projet ajouté");
    }

    /***
     *
     * @param idProjet
     * @return The projet with id $idProjet if it exists
     */
    public Optional<Projet> chercher(int idProjet) {
        return projetRepository.findById(idProjet);
    }

    /**
     * @param projet
     */
    public ResponseEntity<String> modifier(int id, Projet projet) {
        projetRepository.findById(id)
                .ifPresentOrElse(p -> {
                    p.setId(projet.getId());
                    p.setNom(projet.getNom());
                    p.setDescription(projet.getDescription());
                    p.setDateDebut(projet.getDateDebut());
                    p.setDateFin(projet.getDateFin());
                    p.setUtilisateur(projet.getUtilisateur());
                    p.setTaches(projet.getTaches());
                    projetRepository.save(p);
                }, () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Le projet n'existe pas");
                });
        return ResponseEntity.ok().body("Utilisateur modifié");

    }

    /**
     * @param idProjet
     */
    public ResponseEntity<String> supprimer(int idProjet) {
        projetRepository.findById(idProjet)
                .ifPresentOrElse(
                        (p) -> {
                            projetRepository.deleteById(idProjet);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Projet inexistant");
                        }

                );
        return ResponseEntity.accepted().body("Projet supprimé");
    }
}
