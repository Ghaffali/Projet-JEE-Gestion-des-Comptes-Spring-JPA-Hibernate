package tn.ghaffari.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ghaffari.dao.CompteRepository;
import tn.ghaffari.dao.OperationRepository;
import tn.ghaffari.entities.Compte;
import tn.ghaffari.entities.CompteCourant;
import tn.ghaffari.entities.Operation;
import tn.ghaffari.entities.Retrait;
import tn.ghaffari.entities.Versement;
@Service//pour que spring instancier au demarrage 
@Transactional  //demander a spring de gerer les transactions au niveau de la couche metier 
public class BanqueMetierImpl implements IBanqueMetier {
	@Autowired //demander au spring d'injecter linterface compteRep(injection des dep  )
private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Override
	public Compte consulterCompte(String codeCpte) {
Compte cp= compteRepository.findOne(codeCpte);
if (cp==null) throw new RuntimeException("Compte introuvavle");
return cp;
	}

	@Override
	public void verser(String codeCpte, double montant) {
Compte cp = consulterCompte(codeCpte);
Versement v = new Versement(new Date(), montant, cp);
operationRepository.save(v);
cp.setSolde(cp.getSolde()+montant);
compteRepository.save(cp);
	}

	@Override
	public void retirer(String codeCpte, double montant) {
		Compte cp = consulterCompte(codeCpte);
		double facilitesCaisse=0;
		if(cp instanceof CompteCourant)
			facilitesCaisse= ((CompteCourant) cp).getDecouvert();
		if (cp.getSolde()+facilitesCaisse<montant)
			throw new RuntimeException("Solde insuffisant");
		Retrait r = new Retrait(new Date(), montant, cp);
		operationRepository.save(r);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void virement(String codeCpte1, String codeCpt2, double montant) {
retirer(codeCpte1, montant);	
verser(codeCpt2, montant);

	}

	@Override
	public Page<Operation> listeOperation(String codeCpte, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
