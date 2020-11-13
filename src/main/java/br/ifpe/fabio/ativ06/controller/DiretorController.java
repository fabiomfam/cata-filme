package br.ifpe.fabio.ativ06.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.fabio.ativ06.dao.DiretorDAO;
import br.ifpe.fabio.ativ06.model.Diretor;

@Controller
@RequestMapping("diretor")
public class DiretorController {
	
	@Autowired
	private DiretorDAO diretorDAO;
	
	@GetMapping("")
	public String listarDiretor(Model model) {
		model.addAttribute("diretores", this.diretorDAO.findAll(Sort.by("nome")));
		return "diretor/diretor";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrarDiretor(Diretor diretor) {
		return "diretor/cadastrarDiretor";
	}
	
	@PostMapping("/salvar")
	public String salvarDiretor(@Valid Diretor diretor,BindingResult bd, RedirectAttributes ra ) {
		if (bd.hasErrors()) {
			ra.addFlashAttribute("diretor", diretor);
			return "diretor/cadastrarDiretor";
		}
		this.diretorDAO.save(diretor);
		return "redirect:";
	}
	
	@GetMapping("/alterar")
	public String alterarDiretor(Integer id, Model model) {
		Diretor diretor = this.diretorDAO.getOne(id);
		model.addAttribute("diretor", diretor);
		return "diretor/cadastrarDiretor";
	}
	
	@GetMapping("/excluir")
	public String excluirDiretor(Integer id) {
		this.diretorDAO.deleteById(id);
		return "redirect:";
	}

}
