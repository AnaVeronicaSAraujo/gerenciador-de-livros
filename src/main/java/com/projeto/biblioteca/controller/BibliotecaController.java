package com.projeto.biblioteca.controller;
import org.springframework.ui.Model;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.biblioteca.model.Livro;
import com.projeto.biblioteca.service.LivroService;

@Controller
public class BibliotecaController {

	@Autowired
	private LivroService livroService;
	
	@GetMapping("/bookfy")
	public String bibliotecaatt() {
		return "bookfy";
	}
	
	@GetMapping("/adicionar-livro")
	public String adicionarLivro() {
		return "adicionar-livro";
	}

	@PostMapping("/adicionar-livro")
	public String adicionarLivro(
			@RequestParam("titulo") String titulo,
			@RequestParam("autor") String autor,
			@RequestParam("capa") String capa,
			@RequestParam("playlist") String playlist,

			RedirectAttributes redirectAttributes) {

		try {
			Livro novoLivro = new Livro();
			novoLivro.setTitulo(titulo);
			novoLivro.setAutor(autor);
			novoLivro.setCapa(capa);
			novoLivro.setPlaylist(playlist);

			livroService.salvar(novoLivro);
			redirectAttributes.addFlashAttribute("mensagem", "Livro adicionado com sucesso!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao adicionar o livro.");
		}

		return "redirect:/listar-livros";
	}

	@GetMapping("/listar-livros")
	public String listarLivros(Model model) {
		List<Livro> livros = livroService.buscarTodos();
		model.addAttribute("livros", livros);
		return "listar-livros";
	}


    @GetMapping("/deletar/{id}")
    public String deletarLivro(@PathVariable Long id) {
        livroService.deletar(id);
        return "redirect:/listar-livros";
    }
}
