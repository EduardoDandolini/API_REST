package com.example.demo.controller;

import com.example.demo.dto.request.PessoaRequestDTO;
import com.example.demo.dto.response.PessoaResponseDTO;
import com.example.demo.entity.Pessoa;
import com.example.demo.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/teste")
public class PessoaController {

    private final PessoaService pessoaService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaResponseDTO> findById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(pessoaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> findAll(){
        return ResponseEntity.ok().body(pessoaService.findAll());
    }

    @PostMapping(value = "/register")
    public ResponseEntity<PessoaResponseDTO> register(@RequestBody PessoaRequestDTO pessoaRequestDTO, UriComponentsBuilder uriBuilder){
        PessoaResponseDTO pessoaResponseDTO = pessoaService.register(pessoaRequestDTO);
        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(pessoaResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoaResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaResponseDTO> update(@RequestBody PessoaRequestDTO pessoaRequestDTO, @PathVariable(name = "id") Long id){
        return ResponseEntity.ok(pessoaService.update(id, pessoaRequestDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id ) {
        return ResponseEntity.ok().body(pessoaService.delete(id));
    }
 }
