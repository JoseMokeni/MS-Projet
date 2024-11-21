package tn.itbs.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.itbs.projet.model.Etiquette;

@Repository
public interface EtiquetteRepository extends JpaRepository<Etiquette, Integer> {
}
