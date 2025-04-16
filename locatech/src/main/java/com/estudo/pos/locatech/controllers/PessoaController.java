package com.estudo.pos.locatech.controllers;

import com.estudo.pos.locatech.entities.Pessoa;
import com.estudo.pos.locatech.services.PessoaService;
import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/pessoas")
@Tag(name = "Pessoas", description = "Gerenciamento de Pessoas")
public class PessoaController {

    private final PessoaService PessoasService;

    public PessoaController(PessoaService PessoasService) {
        this.PessoasService = PessoasService;
    }

    @GetMapping()
    public ResponseEntity<List<Pessoa>> findAllPessoas(
            @RequestParam("size") int size,
            @RequestParam("page") int page) {
        log.info("Buscando todos os Pessoas");
        var pessoas = this.PessoasService.findAllPessoa(size, page);
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> findPessoa(@PathVariable Long id) {
        log.info("Buscando Pessoa com id {}", id);
        var pessoas = this.PessoasService.findPessoaById(id);
        return ResponseEntity.ok(pessoas);
    }

    @PostMapping
    public ResponseEntity<Void> savePessoa(@RequestBody Pessoa pessoas) {
        log.info("Salvando Pessoa {}", pessoas);
        this.PessoasService.savePessoa(pessoas);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePessoa(@RequestBody Pessoa pessoas, @PathVariable Long id) {
        log.info("Atualizando Pessoa {}", pessoas);
        this.PessoasService.updatePessoa(pessoas, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        log.info("Deletando Pessoa com id {}", id);
        this.PessoasService.deletePessoa(id);
        return ResponseEntity.ok().build();
    }


}
