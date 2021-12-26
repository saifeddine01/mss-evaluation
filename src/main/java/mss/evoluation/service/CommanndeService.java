package mss.evoluation.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mss.evoluation.dto.CommandeDto;
import mss.evoluation.model.Client;
import mss.evoluation.model.Commande;
import mss.evoluation.model.LigneCommande;
import mss.evoluation.repository.ClientRepo;
import mss.evoluation.repository.CommandeRepo;

@Service
@AllArgsConstructor
@Slf4j
public class CommanndeService {
	private final CommandeRepo commandeRepo;
	private final ClientRepo clientRepo;
	private final ModelMapper mapper;

	@Transactional
	public Commande addCommande(CommandeDto req) {
		log.info("Add a new Commande");
		ArrayList<Client> client=new ArrayList<>();
		Client cl=clientRepo.findById(req.getClientId())
				.orElseThrow(()->new EntityNotFoundException(req.getClientId()));
		BigDecimal prix = new BigDecimal(req.getPrixTotal());
		client.add(cl);
		Commande cmd = Commande.builder().date(req.getDate()).prixTotal(prix).client(client)
				.etat(req.getEtat()).build();

		return commandeRepo.save(cmd);
	}

	public List<Commande> getAllCommandes() {
		log.info("Getting all commandes");
		return commandeRepo.findAll();
	}

	public Commande getCommandeByNumero(String numero) {
		log.info("Getting commande by numero");
		return commandeRepo.findById(numero)
				.orElseThrow(() -> new EntityNotFoundException("could find commande with numero :" + numero));
	}

	public void deleteCommande(String id) {
		log.info("Deleting a commande with numero");
		if (commandeRepo.existsById(id)) {
			commandeRepo.deleteById(id);
		}
		throw new EntityNotFoundException("Could not find Commande with id: " + id);

	}

}
