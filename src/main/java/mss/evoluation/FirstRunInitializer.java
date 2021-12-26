package mss.evoluation;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.var;
import lombok.extern.slf4j.Slf4j;
import mss.evoluation.dto.CategorieDto;
import mss.evoluation.dto.ClientRequest;
import mss.evoluation.dto.CommandeDto;
import mss.evoluation.dto.ProduitDto;
import mss.evoluation.repository.ClientRepo;
import mss.evoluation.service.CategorieService;
import mss.evoluation.service.ClientService;
import mss.evoluation.service.CommanndeService;
import mss.evoluation.service.LigneCommandeService;
import mss.evoluation.service.ProduitService;

@Component
@Slf4j
@RequiredArgsConstructor
public class FirstRunInitializer implements ApplicationListener<ContextRefreshedEvent> {

	private final ClientService clientservice;
	private final ProduitService produitService;
	private final LigneCommandeService ligneService;
	private final CommanndeService commandeSerice;
	private final CategorieService categorieService;
	private final ClientRepo repo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("Checking for database initialisation state.");
		log.info("verifing if our database in empty");
		if (repo.count() >0) {
			log.info("starting initialising database");
			
			/*
			 *Client iniatlisation
			 */
			log.info("We start by adding a new client.");
			ClientRequest client = ClientRequest.builder().nom("saifeddine").prenom("sassi")
					.dateNaissance(LocalDate.of(1996, Month.JANUARY, 8)).adresse("avenue mohamed souissi")
					.ville("NABEUL").codePostal(8077L).tel("29280596").fax("29280596").gsm("29280596")
					.email("saifeddine.sassi@esprit.tn").build();
			var resClient = clientservice.addClient(client);
			log.info("Client added  with email : saifeddine.sassi@esprit.tn");
			
			/*
			 *Commande iniatlisation
			 */
			log.info("adding commande ......");
			CommandeDto commande = CommandeDto.builder().date(LocalDate.of(1996, Month.JANUARY, 8)).etat(55L)
					.clientId(resClient.getCode()).prixTotal("222").build();
			var resCommande = commandeSerice.addCommande(commande);
			log.info("Commande added successfully");
			/*
			 *Produit iniatlisation
			 */
			log.info("adding produit ......");
			ProduitDto produit = ProduitDto.builder().marque("AUDI").prixUnitaire("12").modele("A4")
					.caracteristiques("voiture puissante").quantite(50L).build();
			var produitRes = produitService.addProduit(produit);
			log.info(produitRes.getCode());
			log.info("adding added succefully");
			/*
			 *Categorie iniatlisation
			 */
			
			Set<String> list = new HashSet<>();
			list.add(produitRes.getCode());
			log.info("adding categorie ......");
			CategorieDto categorie = CategorieDto.builder().libelle("DIVERS").codeProduit(list).build();
			var resCategorie = categorieService.addCategorie(categorie);
			log.info("Categorie added successfullty");

		}

	}

}
