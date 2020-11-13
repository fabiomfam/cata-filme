package br.ifpe.fabio.ativ06.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.fabio.ativ06.access.Usuario;
import br.ifpe.fabio.ativ06.access.UsuarioDAO;
import br.ifpe.fabio.ativ06.access.Util;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@GetMapping("/")
	public String exibirIndex(Usuario usuario) {
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@PostMapping("login")
	public String logar(Usuario usuario, HttpSession session, RedirectAttributes ra) {
		usuario = this.usuarioDAO.findByLoginAndSenha(usuario.getLogin(), Util.md5(usuario.getSenha()));
		if (usuario != null) {
			//Guardar na sessao o objeto usuario
			session.setAttribute("usuarioOn", usuario);
			return "/home";
		} else {
			ra.addFlashAttribute("mensagem", "Login ou Senha inválidos.");
			return "redirect:/";
		}
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/acessoNegado")
	public String acessoNegado() {
		return "acessoNegado";
	}
}
