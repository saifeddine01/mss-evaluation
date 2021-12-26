package mss.evoluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mss.evoluation.model.Client;

public interface ClientRepo extends JpaRepository<Client, String> {

}
