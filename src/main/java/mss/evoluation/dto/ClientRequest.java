package mss.evoluation.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ClientRequest {
	@NotBlank
	private String nom;
	@NotBlank
	private String prenom;
	private LocalDate dateNaissance;
	@NotBlank
	private String adresse;
	@NotBlank
	private String ville;
	private Long codePostal;
	@NotBlank
	private String tel;
	@NotBlank
	private String fax;
	@NotBlank
	private String gsm;
	@NotBlank
	private String email;

}
