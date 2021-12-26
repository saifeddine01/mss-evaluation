package mss.evoluation.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import mss.evoluation.util.BaseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Produit extends BaseEntity {

	private static final long serialVersionUID = 2936438243414772277L;
	private String marque;
	private String modele;
	private String caracteristiques;
	private BigDecimal prixUnitaire;
	private Long quantite;
	@JsonIgnore
	@OneToMany(mappedBy = "produit")
    Set<LigneCommande> lignescommandes;
}
