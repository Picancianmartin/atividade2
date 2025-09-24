package com.example.atividade2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.atividade2.models.Diretor;
import com.example.atividade2.models.Filme;


@SpringBootApplication
public class Atividade2Application {

	@Bean
	public CommandLineRunner init (
		@Autowired com.example.atividade2.repositories.DiretorRepository diretorRepository,
		@Autowired com.example.atividade2.repositories.FilmeRepository filmeRepository) { 
		return args -> {

			diretorRepository.save(
				new Diretor("Tom Cruise")
			);
			diretorRepository.save(
				new Diretor("Adam Sandler")
			);

			filmeRepository.save(
				new Filme(null, "Missão Impossível", 120, diretorRepository.findById(1L).orElse(null))
			);
			filmeRepository.save(
				new Filme(null, "Gente Grande", 90, diretorRepository.findById(2L).orElse(null))
			);
			filmeRepository.save(
				new Filme(null, "Top Gun", 110, diretorRepository.findById(1L).orElse(null))
			);
			filmeRepository.save(
				new Filme(null, "Esposa de Mentirinha", 100, diretorRepository.findById(2L).orElse(null))
			);

			System.out.println("🍿 Filmes com duração maior que 110 minutos:");
			filmeRepository.findByDuracaoGreaterThan(110).forEach(System.out::println);
			System.out.println();
			System.out.println("🍿 Filmes com duração menor ou igual a 100 minutos:");
			filmeRepository.findByDuracaoLessThanEqual(100).forEach(System.out::println);
			System.out.println();
			System.out.println("🍿 Filmes com 'Gente' no título:");
			filmeRepository.findByTituloLike("%Gente%").forEach(System.out::println);
			System.out.println();

			System.out.println("🎬 Diretores com 'Tom' no nome:");
			diretorRepository.findByNomeLike("%Tom%").forEach(System.out::println);
			System.out.println();
			System.out.println("🎬 + 🍿 Diretores e seus filmes:");
			diretorRepository.findAllWithFilmes().forEach(System.out::println);
			System.out.println();
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Atividade2Application.class, args);
	}

}