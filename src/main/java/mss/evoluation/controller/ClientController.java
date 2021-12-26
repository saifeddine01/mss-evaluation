package mss.evoluation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mss.evoluation.dto.ClientRequest;
import mss.evoluation.model.Client;
import mss.evoluation.service.ClientService;

@RestController
@AllArgsConstructor
//@Validated
@RequestMapping("client")

public class ClientController {
	private final ClientService service;

	@Operation(summary = "Crate a new CLient")
	@PostMapping()
	public Client addClient(@Valid @RequestBody ClientRequest req) {
		return service.addClient(req);
	}
	@Operation(summary = "Get All Client in a simple List (Not recommmended)")
	@GetMapping()
	public List<Client> getClients() {
		return service.getClients();
	}
	@Operation(summary = "Get All Client with Pagination")
	@GetMapping(path = "/all")
	public Page<Client> pageableGetClients(@Param("pageNo") int pageNo,@Param("pageSize") int pageSize,@Param("sortBy") String sortBy){
		return service.getPageClient(pageNo, pageSize, sortBy);
	}

}
