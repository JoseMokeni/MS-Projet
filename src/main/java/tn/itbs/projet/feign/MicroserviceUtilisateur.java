package tn.itbs.projet.feign;

import lombok.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.itbs.projet.model.Utilisateur;

import java.util.Optional;

@FeignClient(name = "microservice-utilisateur", url = "${microservice.utilisateur.url}")
public interface MicroserviceUtilisateur {
    @GetMapping("/utilisateur/chercher/{id}")
    Optional<Utilisateur> chercher(@PathVariable int id);

}
