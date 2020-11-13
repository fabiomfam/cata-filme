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

import br.ifpe.fabio.ativ06.dao.GeneroDAO;
import br.ifpe.fabio.ativ06.model.Genero;

@Controller
@RequestMapping("genero")
public class GeneroController {
	
	@Autowired
	private GeneroDAO generoDAO;
	
	@GetMapping("")
	public String listarGenero(Model model) {
		model.addAttribute("generos", this.generoDAO.findAll(Sort.by("titulo")));
		return "genero/genero";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrarGenero(Genero genero) {
		return "genero/cadastrarGenero";
	}
	
	@PostMapping("/salvar")
	public String salvarGenero(@Valid Genero genero,BindingResult bd, RedirectAttributes ra) {
		if (bd.hasErrors()) {
			ra.addFlashAttribute("genero", genero);
			return "genero/cadastrarGenero";
		}
		this.generoDAO.save(genero);
		return "redirect:";
	}
	
	@GetMapping("/alterar")
	public String alterarGenero(Integer id, Model model) {
		Genero genero = this.generoDAO.getOne(id);
		model.addAttribute("genero", genero);
		return "genero/cadastrarGenero";
	}
	
	@GetMapping("/excluir")
	public String excluirGenero(Integer id) {
		this.generoDAO.deleteById(id);
		return "redirect:";
	}
	
}
