package mss.evoluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mss.evoluation.model.Produit;

public interface ProduitRepo extends JpaRepository<Produit, String>{
	  @Modifying
	  @Query("delete from Produit f where f.code=:code")
	  void deleteproduitbyIds(@Param("code") String code);
}
