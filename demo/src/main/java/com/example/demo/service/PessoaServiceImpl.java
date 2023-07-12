package com.example.demo.service;

import com.example.demo.dto.request.PessoaRequestDTO;
import com.example.demo.dto.response.PessoaResponseDTO;
import com.example.demo.entity.Pessoa;
import com.example.demo.repository.PessoaRepositorio;
import com.example.demo.util.PessoaMapeador;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService{

    private final PessoaRepositorio pessoaRepositorio;

    private final PessoaMapeador pessoaMapeador;
    @Override
    public PessoaResponseDTO findById(Long id) {
        return pessoaMapeador.toPessoaDTO(returnPessoa(id));
    }

    @Override
    public List<PessoaResponseDTO> findAll() {
        return pessoaMapeador.toPessoaResponseDTO(pessoaRepositorio.findAll());
    }

    @Override
    public PessoaResponseDTO register(PessoaRequestDTO pessoaDTO) {
        Pessoa pessoa = pessoaMapeador.toPessoa(pessoaDTO);
        return pessoaMapeador.toPessoaDTO(pessoaRepositorio.save(pessoa));
    }

    @Override
    public PessoaResponseDTO update(Long id, PessoaRequestDTO pessoaDTO) {
        Pessoa pessoa = returnPessoa(id);
        pessoaMapeador.updatePessoaData(pessoa, pessoaDTO);
        return pessoaMapeador.toPessoaDTO(pessoaRepositorio.save(pessoa));
    }

    @Override
    public String delete(Long id) {
        pessoaRepositorio.deleteById(id);
        return "Pessoa excluida! ";
    }

    private Pessoa returnPessoa(Long id){
        return pessoaRepositorio.findById(id).orElseThrow(()-> new RuntimeException("Pessoa não existe"));
    }

}
