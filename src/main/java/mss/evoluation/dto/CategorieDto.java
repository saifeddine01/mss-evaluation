package mss.evoluation.dto;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Value;
import mss.evoluation.model.Produit;

@Value
@Builder
public class CategorieDto {
	@NotBlank
	 String libelle;
	@NotBlank
	 Set<String> codeProduit;
}
