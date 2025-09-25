package com.example.atividade2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.atividade2.models.Diretor;
import com.example.atividade2.models.Filme;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Atividade2Application {

	@Bean
	@Transactional
	public CommandLineRunner init(
			@Autowired com.example.atividade2.repositories.DiretorRepository diretorRepository,
			@Autowired com.example.atividade2.repositories.FilmeRepository filmeRepository) {
		return args -> {

			diretorRepository.save(
					new Diretor("Tom Cruise"));
			diretorRepository.save(
					new Diretor("Adam Sandler"));

			filmeRepository.save(
					new Filme(null, "Missão Impossível", 120, diretorRepository.findById(1L).orElse(null)));
			filmeRepository.save(
					new Filme(null, "Gente Grande", 90, diretorRepository.findById(2L).orElse(null)));
			filmeRepository.save(
					new Filme(null, "Top Gun", 110, diretorRepository.findById(1L).orElse(null)));
			filmeRepository.save(
					new Filme(null, "Esposa de Mentirinha", 100, diretorRepository.findById(2L).orElse(null)));

			System.out.println("\n🍿 Filmes com duração maior que 110 minutos:");
			List<Filme> filmesLongos = filmeRepository.findByDuracaoGreaterThanWithDiretor(110);
			filmesLongos.forEach(Filme -> System.out.println("  - " + Filme.getTitulo() + " (" + Filme.getDuracao()
					+ " min) - Diretor: " + Filme.getDiretor().getNome()));

			System.out.println("\n🍿 Filmes com duração menor ou igual a 100 minutos:");
			List<Filme> filmesCurtos = filmeRepository.findByDuracaoLessThanEqualWithDiretor(110);
			filmesCurtos.forEach(Filme -> System.out.println("  - " + Filme.getTitulo() + " (" + Filme.getDuracao()
					+ " min) - Diretor: " + Filme.getDiretor().getNome()));

			System.out.println("\n🍿 Filmes com 'Gente' no título:");
			List<Filme> filmes = filmeRepository.findByTituloLikeWithDiretor("%Gente%");
			filmes.forEach(Filme -> System.out.println("  - " + Filme.getTitulo() + " (" + Filme.getDuracao()
					+ " min) - Diretor: " + Filme.getDiretor().getNome()));
			

			System.out.println("\n🔍 Buscando diretor por ID (1) com seus filmes:");
			Optional<Diretor> diretorComFilmes = diretorRepository.findByIdWithFilmes(1L);
			if (diretorComFilmes.isPresent()) {
				Diretor diretor = diretorComFilmes.get();
				System.out.println("   Diretor: " + diretor.getNome());
				System.out.println("   ID: " + diretor.getId());
				System.out.println("   Filmes:");
				for (Filme filme : diretor.getFilmes()) {
					System.out.println("     - " + filme.getTitulo() + " (" + filme.getDuracao() + " min)");
				}
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Atividade2Application.class, args);
	}

}