package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
    
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	// @RequestMapping(value = "/index",method = RequestMethod.GET)
	//@GetMapping(value = { "/index", "", "/", "/home" })
	//@RequestMapping(value="/index")
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("titulo", "holas spring Model");
		return "app/index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("KING");
		usuario.setApellido("DAZA");
		usuario.setEmail("e.daza@udla.edu.co");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "USUARIO: ".concat(usuario.getNombre()));
		return "perfil";

	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("KING", "DAZA", "e.daza@udla.edu.co"));
		usuarios.add(new Usuario("andres", "aullon", "e.daza@udla.edu.co"));
		usuarios.add(new Usuario("cristian", "rojas", "e.daza@udla.edu.co"));
		usuarios.add(new Usuario("pedro", "diaz", "e.daza@udla.edu.co"));
		usuarios.add(new Usuario("angie", "mendez", "e.adsdaza@udla.edu.co"));
		model.addAttribute("titulo", "listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}

	/*
	 * @ModelAttribute("usuarios") public List<Usuario> poblarUsuarios(){
	 * List<Usuario> usuarios = Arrays.asList(new Usuario("KING", "DAZA",
	 * "e.daza@udla.edu.co"), new Usuario("andres", "aullon", "e.daza@udla.edu.co"),
	 * new Usuario("angie", "mendez", "e.adsdaza@udla.edu.co")); return usuarios;
	 * 
	 * }
	 */
}
