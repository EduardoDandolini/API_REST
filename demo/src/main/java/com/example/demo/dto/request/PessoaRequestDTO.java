package com.example.demo.dto.request;

import lombok.Data;
import lombok.Getter;

@Getter
public class PessoaRequestDTO {
    private String name;

    private String cpf;

    private Integer age;
}
