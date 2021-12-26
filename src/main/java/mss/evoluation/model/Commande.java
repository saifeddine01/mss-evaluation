package mss.evoluation.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "numero")
public class Commande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7972311710883541100L;

	@Id
	@GeneratedValue(generator = "nano-generator")
	@GenericGenerator(name = "nano-generator", strategy = "mss.evoluation.util.NanoGenerator")
	private String numero;

	private LocalDate date;
	private BigDecimal prixTotal;
	private Long etat;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Client> client = new ArrayList<>();
	
	@OneToMany(mappedBy = "commande")
    Set<LigneCommande> lignescommandes;

}
