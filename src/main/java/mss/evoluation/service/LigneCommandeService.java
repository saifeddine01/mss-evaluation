package mss.evoluation.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mss.evoluation.DoneResponse;
import mss.evoluation.dto.LigneCommandeDto;
import mss.evoluation.model.Commande;
import mss.evoluation.model.LigneCommande;
import mss.evoluation.model.Produit;
import mss.evoluation.repository.CommandeRepo;
import mss.evoluation.repository.LigneCommandeRepo;
import mss.evoluation.repository.ProduitRepo;

@Service
@AllArgsConstructor
@Slf4j
public class LigneCommandeService {

	private final CommandeRepo commandeRepo;
	private final ProduitRepo produitRepo;
	private final LigneCommandeRepo ligneRepo;

	@Transactional
	public LigneCommande addLigneCommande(String commandeId, String produitId) {
		log.info("Commander un produit methode");
		Commande commande = commandeRepo.findById(commandeId).orElseThrow(() -> new EntityNotFoundException(produitId));

		Produit produit = produitRepo.findById(produitId).orElseThrow(() -> new EntityNotFoundException(produitId));

		LigneCommande ligne = LigneCommande.builder().prixTotal(commande.getPrixTotal())
				.prixUnitaire(produit.getPrixUnitaire()).etat(commande.getEtat()).qte(produit.getQuantite())
				.produit(produit).commande(commande).build();
		
		return ligneRepo.save(ligne);

	}

	public DoneResponse removeCommande(String id) {
		log.info("Remove command with  id {}",id);
		if(ligneRepo.existsById(id)) {
			ligneRepo.deleteById(id);
			return new DoneResponse("Commande with id : +"+id+"has been deleted");
		}
		throw new EntityNotFoundException("could not find commande with id "+id);
		

	}

	public void removeCommandeMultiple(List<String> listofIds) {
		for (String ids : listofIds) {
			log.info("checking if the Command exists by Id");
			if(ligneRepo.existsById(ids)) {
			log.info("Removing commands with  id {}",ids);
			ligneRepo.deleteById(ids);
			}
		}

	}

	public List<LigneCommande> getAll() {
		log.info("Fetching all commands");
		return ligneRepo.findAll();
	}
	@Transactional
	public LigneCommande editcommande(LigneCommandeDto dto) {
		log.info("Editing Ligne command");
		LigneCommande ligne = ligneRepo.findById(dto.getIdligne()).orElseThrow(() -> new EntityNotFoundException(dto.getIdligne()));
		Produit produit = produitRepo.findById(dto.getIdproduit()).orElseThrow(() -> new EntityNotFoundException(dto.getIdproduit()));
		Commande commande = commandeRepo.findById(dto.getIdcommande()).orElseThrow(() -> new EntityNotFoundException(dto.getIdcommande()));
		ligne.setProduit(produit);
		ligne.setCommande(commande);
		log.info("Commmand with id {} has been edited ",ligne.getCode());
		return ligneRepo.save(ligne);
	}
}
