package com.example.demo.util;

import com.example.demo.dto.request.PessoaRequestDTO;
import com.example.demo.dto.response.PessoaResponseDTO;
import com.example.demo.entity.Pessoa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class PessoaMapeador {

    public Pessoa toPessoa(PessoaRequestDTO pessoaDTO){
        return Pessoa.builder()
                .name(pessoaDTO.getName())
                .cpf(pessoaDTO.getCpf())
                .age(pessoaDTO.getAge())
                .build();
    }

    public PessoaResponseDTO toPessoaDTO(Pessoa pessoa){
        return new PessoaResponseDTO(pessoa);
    }

    public List<PessoaResponseDTO> toPessoaResponseDTO(List<Pessoa> listaPessoa){
        return listaPessoa.stream().map(PessoaResponseDTO::new).collect(Collectors.toList());
    }

    public void updatePessoaData(Pessoa pessoa, PessoaRequestDTO pessoaDTO){

        pessoa.setName(pessoaDTO.getName());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setAge(pessoaDTO.getAge());
    }
}
