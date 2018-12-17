package tn.ghaffari.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.ghaffari.entities.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
