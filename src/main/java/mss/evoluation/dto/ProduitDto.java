package mss.evoluation.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProduitDto {
	String marque;
	String modele;
	String caracteristiques;
	String prixUnitaire;
	Long quantite;
}
