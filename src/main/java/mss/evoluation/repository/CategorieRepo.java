package mss.evoluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mss.evoluation.model.Categorie;

public interface CategorieRepo extends JpaRepository<Categorie, String> {

}
