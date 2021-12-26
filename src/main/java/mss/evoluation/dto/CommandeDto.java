package mss.evoluation.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CommandeDto {
	private LocalDate date;
	private String prixTotal;
	private Long etat;
	private String clientId;
}
