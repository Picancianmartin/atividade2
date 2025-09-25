package com.example.atividade2.repositories;

import com.example.atividade2.models.Filme;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface FilmeRepository  extends JpaRepository<Filme, Long> {
    
    List<Filme> findByDuracaoGreaterThan(Integer duracao);

    List<Filme> findByDuracaoLessThanEqual(Integer duracao);

    List<Filme> findByTituloLike(String titulo);

    @Query("select f from Filme f left join fetch f.diretor where f.duracao > :duracao")
    List<Filme> findByDuracaoGreaterThanWithDiretor(@Param("duracao") Integer duracao);

    @Query("select f from Filme f left join fetch f.diretor where f.duracao <= :duracao")
    List<Filme> findByDuracaoLessThanEqualWithDiretor(@Param("duracao") Integer duracao);

    @Query("select f from Filme f left join fetch f.diretor where f.titulo like :titulo")
    List<Filme> findByTituloLikeWithDiretor(@Param("titulo") String titulo);

}
