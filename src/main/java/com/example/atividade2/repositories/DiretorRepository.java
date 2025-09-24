package com.example.atividade2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.atividade2.models.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {

   List<Diretor> findByNomeLike(String nome);

   @Query("select d from Diretor d left join fetch d.filmes")
    List<Diretor> findAllWithFilmes();
}
