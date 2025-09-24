package com.example.atividade2.models;

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
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String titulo;

    @Column(nullable = false)
    private Integer duracao; 


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diretor_id") 
    @ToString.Exclude
    private Diretor diretor;
}