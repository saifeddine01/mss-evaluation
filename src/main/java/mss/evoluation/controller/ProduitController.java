package mss.evoluation.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import mss.evoluation.DoneResponse;
import mss.evoluation.dto.ProduitDto;
import mss.evoluation.model.Produit;
import mss.evoluation.service.ProduitService;

@RestController
@AllArgsConstructor
@RequestMapping("produit")
public class ProduitController {

	private final ProduitService service;

	@PostMapping
	public Produit addProduct(@RequestBody ProduitDto dto) {
		return service.addProduit(dto);
	}

	@GetMapping
	public List<Produit> getAllProducts() {
		return service.getProduit();
	}

	@PutMapping
	public Produit editProduit(@RequestBody ProduitDto dto, @PathVariable("code") String code) {
		return service.editProduit(dto, code);

	}

	@DeleteMapping(path = "/{idProduit}")
	public DoneResponse deleteProduit(@PathVariable("idProduit") String idProduit) {
		return service.deleteProduit(idProduit);

	}

}
