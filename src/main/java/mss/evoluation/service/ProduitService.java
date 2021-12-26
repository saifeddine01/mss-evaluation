package mss.evoluation.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.var;
import lombok.extern.slf4j.Slf4j;
import mss.evoluation.DoneResponse;
import mss.evoluation.dto.ProduitDto;
import mss.evoluation.model.Categorie;
import mss.evoluation.model.Produit;
import mss.evoluation.repository.CategorieRepo;
import mss.evoluation.repository.ProduitRepo;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProduitService {
	private final ProduitRepo produitRepo;
	private final CategorieRepo catRepo;
	private final ModelMapper mapper;

	@Transactional
	public Produit addProduit(ProduitDto dto) {
		log.info("Adding a new product {}", dto);
		Produit prod = new Produit();
		BigDecimal prixUnit = new BigDecimal(dto.getPrixUnitaire());
		prod.setPrixUnitaire(prixUnit);
		mapper.map(dto, prod);
		log.info(dto.toString());
		return produitRepo.save(prod);

	}

	public List<Produit> getProduit() {
		log.info("Fetching all products");
		return produitRepo.findAll();
	}

	public Produit getProduiById(String code) {
		log.info("GET product by code");
		return produitRepo.findById(code)
				.orElseThrow(() -> new EntityNotFoundException("could find produit with code :" + code));
	}

	public DoneResponse deleteProduit(String code) {
		log.info("Deleting Product");
		if (produitRepo.existsById(code)) {
			produitRepo.deleteById(code);
			return new DoneResponse("Produit with id :" + code + " has been deleted");
		}
		throw new EntityNotFoundException("Could not find Product with code :" + code);
	}

	public Produit editProduit(ProduitDto dto, String id) {
		Produit prod = produitRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("could not find produit with code " + id));
		log.info("produit findby");
		log.info(prod.toString());
		mapper.map(dto, prod);
		log.info("produit after mapping");
		log.info(prod.toString());
		return produitRepo.save(prod);
	}
}
