package mss.evoluation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import mss.evoluation.dto.CategorieDto;
import mss.evoluation.model.Categorie;
import mss.evoluation.service.CategorieService;

@RestController
@AllArgsConstructor
@RequestMapping("categorie")
public class CategorieController {
	private final CategorieService categorieService;
	@PostMapping()
	public Categorie addCategorie(@RequestBody CategorieDto dto) {
		return categorieService.addCategorie(dto);
	}
	@GetMapping
	public List<Categorie> getAllCategorie(){
		return categorieService.getAllCategorie();
	}
	@GetMapping(path = "/{code}")
	public Categorie getCategorieByCode(@PathVariable("code")String code){
		return categorieService.getCategorieByCode(code);
	}
	@DeleteMapping
	public void DeleteCategorieByCode(@PathVariable("code")String code){
		 categorieService.deleteCategorie(code);
	}
	

}
