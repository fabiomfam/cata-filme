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
import br.ifpe.fabio.ativ06.dao.FilmeDAO;
import br.ifpe.fabio.ativ06.dao.GeneroDAO;
import br.ifpe.fabio.ativ06.model.Filme;

@Controller
@RequestMapping("filme")
public class FilmeController {
	
	@Autowired
	private FilmeDAO filmeDAO;

	@Autowired
	private DiretorDAO diretorDAO;
	
	@Autowired
	private GeneroDAO generoDAO;
	
	@GetMapping("")
	public String listarFilme(Model model) {
		model.addAttribute("filmes", this.filmeDAO.findAll(Sort.by("titulo")));
		return "filme/filme";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrarFilme(Filme filme, Model model) {
		model.addAttribute("generos", this.generoDAO.findAll(Sort.by("titulo")));
		model.addAttribute("diretores", this.diretorDAO.findAll(Sort.by("nome")));
		return "filme/cadastrarFilme";
	}
	
	@PostMapping("/salvar")
	public String salvarFilme(@Valid Filme filme,BindingResult bd, RedirectAttributes ra ) {
		if (bd.hasErrors()) {
			ra.addFlashAttribute("filme", filme);
			return "filme/cadastrarFilme";
		}
		this.filmeDAO.save(filme);
		return "redirect:";
	}
	
	@GetMapping("/alterar")
	public String alterarFilme(Integer id, Model model) {
		model.addAttribute("generos", this.generoDAO.findAll(Sort.by("titulo")));
		model.addAttribute("diretores", this.diretorDAO.findAll(Sort.by("nome")));
		Filme filme = this.filmeDAO.getOne(id);
		model.addAttribute("filme", filme);
		return "filme/cadastrarFilme";
	}
	
	@GetMapping("/excluir")
	public String excluirFilme(Integer id) {
		this.filmeDAO.deleteById(id);
		return "redirect:";
	}
}
