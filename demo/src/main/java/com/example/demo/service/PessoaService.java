package com.example.demo.service;

import com.example.demo.dto.request.PessoaRequestDTO;
import com.example.demo.dto.response.PessoaResponseDTO;

import java.util.List;


public interface PessoaService {

    PessoaResponseDTO findById(Long id);

    List<PessoaResponseDTO> findAll();

    PessoaResponseDTO register(PessoaRequestDTO pessoaDTO);

    PessoaResponseDTO update(Long id, PessoaRequestDTO pessoaDTO);

    String delete(Long id);
}
