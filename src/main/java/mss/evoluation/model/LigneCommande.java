package mss.evoluation.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import mss.evoluation.util.BaseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class LigneCommande extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "produit_id")
	Produit produit;

	@ManyToOne
	@JoinColumn(name = "commande_id")
	Commande commande;

	private Long qte;
	private BigDecimal prixUnitaire;
	private BigDecimal prixTotal;
	private Long etat;
}
