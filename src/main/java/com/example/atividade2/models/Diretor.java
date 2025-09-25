package com.example.atividade2.models;


import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Diretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "diretor", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Filme> filmes;

    public Diretor(String nome) {
        this.nome = nome;
    }
}
