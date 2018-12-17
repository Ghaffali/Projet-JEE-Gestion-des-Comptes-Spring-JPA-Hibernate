package tn.ghaffari.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.ghaffari.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
 