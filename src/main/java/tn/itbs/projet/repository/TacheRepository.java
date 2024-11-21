package tn.itbs.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.itbs.projet.model.Tache;

import java.util.ArrayList;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Integer> {
    ArrayList<Tache> findByProjetId(int idProjet);

}
