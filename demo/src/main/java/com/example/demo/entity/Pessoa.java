package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "age", nullable = false)
    private Integer age;
    @Builder
    public Pessoa(String name, String cpf, Integer age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }
}
