package tn.ghaffari.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		Page<Operation> pageOperation = banqueMetier.listeOperation(codeCompte, 0, 4);
		model.addAttribute("listOperations", pageOperation.getContent());

		try {
			Compte cp = banqueMetier.consulterCompte(codeCompte);
			model.addAttribute("compte", cp); // pour stoquer obect dans model
		} catch (Exception e) {
			model.addAttribute("exception", e);
		}

		return "comptes";
	}

	@RequestMapping(value = "/saveOperation", method = RequestMethod.POST)
	public String saveOperation(Model model, String typeOperation, String codeCompte, double montant,
			String codeCompte2) {
		try {
			if (typeOperation.equals("VERS")) {
				banqueMetier.verser(codeCompte, montant);
			} else if (typeOperation.equals("RET")) {
				banqueMetier.retirer(codeCompte, montant);
			}
			if (typeOperation.equals("VIR")) {
				banqueMetier.virement(codeCompte, codeCompte2, montant);
			}

		} catch (Exception e) {
			model.addAttribute("error", e);
		}

		return "redirect:/consulterCompte?codeCompte="+codeCompte;
	}
}
