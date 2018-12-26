package tn.ghaffari;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import tn.ghaffari.dao.ClientRepository;
import tn.ghaffari.dao.CompteRepository;
import tn.ghaffari.dao.OperationRepository;
import tn.ghaffari.entities.Client;
import tn.ghaffari.entities.Compte;
import tn.ghaffari.entities.CompteCourant;
import tn.ghaffari.entities.CompteEpargne;
import tn.ghaffari.entities.Operation;
import tn.ghaffari.entities.Retrait;
import tn.ghaffari.entities.Versement;
import tn.ghaffari.metier.IBanqueMetier;

@SpringBootApplication
public class MyBanqueApplication implements CommandLineRunner {
@Autowired
	private ClientRepository clientRepository;

@Autowired
 private CompteRepository compteRepository;

@Autowired
private OperationRepository operationRepository;

@Autowired
private IBanqueMetier banqueMetier;
	public static void main(String[] args) {
		SpringApplication.run(MyBanqueApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		

	/*	Client c1 =clientRepository.save(new Client("ALi","ghaffari@hotmail.fr"));
		Client c2= clientRepository.save(new Client("Med","ali.ghaffari@hotmail.fr"));
		 
		Compte cp1= compteRepository.save(new CompteCourant("c1",new Date(),9000,c1,6000 )); 
		Compte cp2= compteRepository.save(new CompteEpargne("c2",new Date(),6000,c2,5.5 ));
		
		operationRepository.save(new Versement(new Date(),4542,cp1));
		operationRepository.save(new Versement(new Date(),9000,cp1));
		operationRepository.save(new Versement(new Date(),2515,cp1));
		operationRepository.save(new Retrait(new Date(),9000,cp1));

		operationRepository.save(new Versement(new Date(),9000,cp2)); 
		operationRepository.save(new Versement(new Date(),6561,cp2));
		operationRepository.save(new Versement(new Date(),5452,cp2));
		operationRepository.save(new Retrait(new Date(),9000,cp2));
		
		
		banqueMetier.verser("c1", 11111111);*/
	}

}

