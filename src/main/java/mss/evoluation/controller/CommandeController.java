package mss.evoluation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import mss.evoluation.dto.CommandeDto;
import mss.evoluation.model.Commande;
import mss.evoluation.service.CommanndeService;

@RestController
@AllArgsConstructor
@RequestMapping("commande")
public class CommandeController {
	private final CommanndeService service;
	@Operation(summary = "Crate a new Commande")
	@PostMapping
	public Commande addCommande(@RequestBody CommandeDto req) {
		return service.addCommande(req);
	}
	@Operation(summary = "Getting alll commands")
	@GetMapping
	public List<Commande> getAllCommande(){
		return service.getAllCommandes();
	}
	@Operation(summary = "Getting command By numero")
	@GetMapping(path = "/{numero}")
	public Commande getCommandeById(@PathVariable("numero")String numero){
		return service.getCommandeByNumero(numero);
	}

}
