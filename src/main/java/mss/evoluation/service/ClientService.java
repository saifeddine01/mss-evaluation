package mss.evoluation.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.var;
import lombok.extern.slf4j.Slf4j;
import mss.evoluation.dto.ClientRequest;
import mss.evoluation.model.Client;
import mss.evoluation.repository.ClientRepo;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ClientService {
	private final ClientRepo clientRepo;
	private final ModelMapper mapper;

	@Transactional
	public Client addClient(ClientRequest req) {
		var client = mapper.map(req, Client.class);
		client.setCode(null);
		return clientRepo.save(client);

	}

	public List<Client> getClients() {
		return clientRepo.findAll();
	}

	public Page<Client> getPageClient(int pageNo, int pageSize, String sortBy) {
		PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		return clientRepo.findAll(paging);
	}
}
