package tn.ghaffari.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.ghaffari.entities.Compte;
import tn.ghaffari.entities.Operation;
import tn.ghaffari.metier.IBanqueMetier;

@Controller 
public class BanqueController {
@Autowired
	private IBanqueMetier banqueMetier;
	
	

@RequestMapping("/operations")
	public String index() {
		return "comptes";
	}
@RequestMapping("/consulterCompte")
public String consulter(Model model, String codeCompte) {
	model.addAttribute("codeCompte", codeCompte);
	Page<Operation> pageOperation=banqueMetier.listeOperation(codeCompte, 0, 4);
	model.addAttribute("listOperations",pageOperation.getContent());
	
	try {
		Compte cp= banqueMetier.consulterCompte(codeCompte);
		model.addAttribute("compte", cp); //pour stoquer obect dans model
	} catch (Exception e) {
		model.addAttribute("exeption",e);
	}
	
	return "comptes";
}




}
