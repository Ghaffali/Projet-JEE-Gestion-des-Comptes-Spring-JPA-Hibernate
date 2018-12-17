package tn.ghaffari.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.ghaffari.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {

}
