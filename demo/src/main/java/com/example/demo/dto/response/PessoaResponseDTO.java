package com.example.demo.dto.response;

import com.example.demo.entity.Pessoa;
import lombok.Data;
import lombok.Getter;

@Getter
public class PessoaResponseDTO {

    private Long id;

    private String name;

    private String cpf;

    private Integer age;


    public PessoaResponseDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.name = pessoa.getName();
        this.cpf = pessoa.getCpf();
        this.age = pessoa.getAge();
    }
}
