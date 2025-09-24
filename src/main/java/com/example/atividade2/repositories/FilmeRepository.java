package com.example.atividade2.repositories;

import com.example.atividade2.models.Filme;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FilmeRepository  extends JpaRepository<Filme, Long> {
    
    List<Filme> findByDuracaoGreaterThan(Integer duracao);

    List<Filme> findByDuracaoLessThanEqual(Integer duracao);

    List<Filme> findByTituloLike(String titulo);

}
