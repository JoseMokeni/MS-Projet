package tn.itbs.projet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.itbs.projet.model.Tache;
import tn.itbs.projet.repository.TacheRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TacheService {
    @Autowired
    private TacheRepository tacheRepository;

    /**
     * @param tache
     */
    public ResponseEntity<String> ajouter(Tache tache) {
        tacheRepository.findById(tache.getId())
                .ifPresentOrElse(p -> {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Utilisateur déjà existant");
                }, () -> tacheRepository.save(tache)
                );
        return ResponseEntity .ok("Tache ajoutée avec succès");
    }

    public Optional<Tache> chercher(int idTache) {
        return tacheRepository.findById(idTache);
    }

    public ResponseEntity<String> supprimer(int idTache) {
        tacheRepository.findById(idTache)
                .ifPresentOrElse(
                        (t) -> {
                            tacheRepository.deleteById(idTache);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tache inexistante");
                        }
                );
        return ResponseEntity.ok("Tache supprimée avec succès");
    }

    public ResponseEntity<String> modifier(int id, Tache tache) {
        tacheRepository.findById(id)
                .ifPresentOrElse(
                        (t) -> {
                            t.setId(tache.getId());
                            t.setTitre(tache.getTitre());
                            t.setDescription(tache.getDescription());
                            t.setDateEcheance(tache.getDateEcheance());
                            t.setStatus(tache.getStatus());
                            t.setProjet(tache.getProjet());
                            t.setEtiquettes(tache.getEtiquettes());
                            tacheRepository.save(t);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tache inexistante");
                        }
                );
        return ResponseEntity.ok("Tache modifiée avec succès");
    }

    public ResponseEntity<String> changerEtat(int idTache, String etat) {
        tacheRepository.findById(idTache)
                .ifPresentOrElse(
                        (t) -> {
                            t.setStatus(etat);
                            tacheRepository.save(t);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tache inexistante");
                        }
                );
        return ResponseEntity.ok("Etat changé avec succès");
    }

    /**
     * @param idProjet
     * @return The tasks of the project with id $idProjet if it exists
     */
    public ArrayList<Tache> chercherParProjet(int idProjet) {
        return tacheRepository.findByProjetId(idProjet);
    }

}
