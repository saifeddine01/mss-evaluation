package mss.evoluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mss.evoluation.model.LigneCommande;

public interface LigneCommandeRepo extends JpaRepository<LigneCommande, String> {
}
