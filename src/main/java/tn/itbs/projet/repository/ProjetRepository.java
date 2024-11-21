package tn.itbs.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.itbs.projet.model.Projet;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Integer> {
}
