package com.projeto.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.biblioteca.model.Livro;
import com.projeto.biblioteca.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }
    
    public Livro buscarPorId(Long id) {
        return livroRepository.findById(id).orElse(null);
    }
    
    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }
    
    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}
