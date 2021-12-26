package mss.evoluation.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mss.evoluation.dto.CategorieDto;
import mss.evoluation.model.Categorie;
import mss.evoluation.model.Produit;
import mss.evoluation.repository.CategorieRepo;
import mss.evoluation.repository.ProduitRepo;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class CategorieService {
	private final CategorieRepo Categorierepo;
	
	private final ProduitRepo produitRepo;
	@Transactional
	public Categorie addCategorie(CategorieDto dto) {
		log.info("Adding a category");
		Set<Produit> list = new HashSet<>();
		for (String idproduit : dto.getCodeProduit()) {
			list.add(produitRepo.findById(idproduit).orElseThrow(() -> new EntityNotFoundException(idproduit)));
		}
		Categorie cat=Categorie.builder().libelle(dto.getLibelle()).produitsCategory(list).build();
		return Categorierepo.save(cat);
	}

	public void deleteCategorie(String code) {
		if(Categorierepo.existsById(code)) {
		log.info("Deleting a category");
		Categorierepo.deleteById(code);
	
			throw new EntityNotFoundException("Could not find categorie with code :"+code);

		}
	}

	public List<Categorie> getAllCategorie() {
		log.info("Getting all category");
		return Categorierepo.findAll();
	}

	public Categorie getCategorieByCode(String code) {
		log.info("Getting category by code");
		return Categorierepo.findById(code)
				.orElseThrow(() -> new EntityNotFoundException("could find categorie with code :" + code));
	}

}
