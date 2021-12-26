package mss.evoluation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import mss.evoluation.dto.LigneCommandeDto;
import mss.evoluation.model.LigneCommande;
import mss.evoluation.service.LigneCommandeService;

@RestController
@AllArgsConstructor
@RequestMapping("/lignecommande")
public class LigneCommandeController {
	private final LigneCommandeService service;
	@Operation(summary = "add a new line of command")
	@PostMapping
	public LigneCommande addLigneCommande(@RequestParam("idProduit") String idproduit,
			@RequestParam("numCommande") String numCommande) {
		return service.addLigneCommande(numCommande, idproduit);
	}
	@Operation(summary = "delete a commmand line")
	@DeleteMapping
	public ResponseEntity<String> deleteCommande(@RequestParam("id") String id) {
		service.removeCommande(id);
		return new ResponseEntity<>("Commande removed successfuly", HttpStatus.OK);
	}
	@Operation(summary = "getting all lines")
	@GetMapping
	public List<LigneCommande> getAll() {
		return service.getAll();
	}
	@Operation(summary = "delete many lines on the same time")
	@DeleteMapping(path = "/all")
	public void deleteCommandeMultiple(@RequestBody List<String> ids) {
		service.removeCommandeMultiple(ids);
	}
	@Operation(summary = "edit a command line ")
	@PutMapping
	public LigneCommande editCommande(@RequestBody LigneCommandeDto dto) {
		return service.editcommande(dto);

	}

}
