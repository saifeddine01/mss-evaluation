package mss.evoluation.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Client extends BaseEntity {
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String adresse;
	private String ville;
	private Long codePostal;
	private String tel;
	private String fax;
	private String gsm;
	private String email;
	/*
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Commande> comments = new ArrayList<>();
	*/

}
