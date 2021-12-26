package mss.evoluation.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.var;
import lombok.extern.slf4j.Slf4j;
import mss.evoluation.model.Client;
import mss.evoluation.repository.ClientRepo;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class CLientRepoTest {
	@Mock
	ClientRepo repo;

	@Test
	void createClientTest() {
		Client client = Client.builder().nom("saifeddine").prenom("sassi")
				.dateNaissance(LocalDate.of(1996, Month.JANUARY, 8)).adresse("avenue mohamed souissi").ville("NABEUL")
				.codePostal(8077L).tel("29280596").fax("29280596").gsm("29280596").email("saifeddine.sassi@esprit.tn")
				.build();

		when(repo.save(any())).thenAnswer(returnsFirstArg());
		log.info(client.toString());
		var res = repo.save(client);
		assertThat(res).isNotNull();
		log.info(res.toString());
		assertThat(res.getTel()).isEqualTo("29280596");
	}

	@Test
	void getClient() {
		Client client1 = Client.builder().nom("client1").prenom("foulen")
				.dateNaissance(LocalDate.of(1996, Month.JANUARY, 8)).adresse("avenue mohamed souissi").ville("NABEUL")
				.codePostal(8014L).tel("29280596").fax("29280596").gsm("29280596").email("saifeddine.sassi@esprit.tn")

				.build();
		Client client2 = Client.builder().nom("client2").prenom("foulen")
				.dateNaissance(LocalDate.of(1996, Month.JANUARY, 8)).adresse("avenue mohamed souissi").ville("NABEUL")
				.codePostal(8022L).tel("29280123").fax("29280123").gsm("29280123").email("saifeddine.sassi@esprit.tn")
				.build();
		repo.save(client1);
		repo.save(client2);
		var res = repo.findAll();
		assertThat(res).isNotNull();
	}

	@Test
	void getClientById() {
		Client client1 = Client.builder().nom("client1").prenom("foulen")
				.dateNaissance(LocalDate.of(1996, Month.JANUARY, 8)).adresse("avenue mohamed souissi").ville("NABEUL")
				.codePostal(8014L).tel("29280596").fax("29280596").gsm("29280596").email("saifeddine.sassi@esprit.tn")
				.build();
		client1.setCode("codeclient");
		repo.save(client1);
		var res = repo.findById("codeclient");
		assertThat(res).isNotNull();
	}

	@Test
	void deleteClient() throws NoSuchElementException {
		Client client1 = Client.builder().nom("client1").prenom("foulen")
				.dateNaissance(LocalDate.of(1996, Month.JANUARY, 8)).adresse("avenue mohamed souissi").ville("NABEUL")
				.codePostal(8014L).tel("29280596").fax("29280596").gsm("29280596").email("saifeddine.sassi@esprit.tn")
				.build();
		client1.setCode("codeclient");
		repo.deleteById("codeclient");
		assertThatThrownBy(() -> {
			repo.findById("codeclient").get();
		}).isInstanceOf(NoSuchElementException.class);

	}

}
