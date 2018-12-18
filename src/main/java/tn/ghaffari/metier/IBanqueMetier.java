package tn.ghaffari.metier;

import org.springframework.data.domain.Page;

import tn.ghaffari.entities.Compte;
import tn.ghaffari.entities.Operation;

public interface IBanqueMetier {
	public Compte consulterCompte(String codeCpte );
public void verser (String codeCpte, double montant);
public void retirer(String codeCpte, double montant);
public void virement (String codeCpt1,String codeCpt2,double montant);
public Page<Operation > listeOperation(String codeCpte, int page, int size);
}
