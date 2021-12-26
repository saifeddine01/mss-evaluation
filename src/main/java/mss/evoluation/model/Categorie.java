package mss.evoluation.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mss.evoluation.util.BaseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Categorie extends BaseEntity {
	private String libelle;
   // @OnDelete(action = OnDeleteAction.CASCADE)

	@OneToMany(fetch = FetchType.LAZY,cascade = { CascadeType.ALL },orphanRemoval = true)
	
	private Set<Produit> produitsCategory=new HashSet();
}
