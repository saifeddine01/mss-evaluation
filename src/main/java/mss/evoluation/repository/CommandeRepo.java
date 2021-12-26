package mss.evoluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mss.evoluation.model.Commande;

public interface CommandeRepo extends JpaRepository<Commande, String> {

}
