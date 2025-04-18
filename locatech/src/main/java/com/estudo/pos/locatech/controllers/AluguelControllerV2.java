package com.estudo.pos.locatech.controllers;

import com.estudo.pos.locatech.dto.AluguelRequestDTO;
import com.estudo.pos.locatech.entities.Aluguel;
import com.estudo.pos.locatech.services.AluguelService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/alugueis")
@Slf4j
public class AluguelControllerV2 {

    private final AluguelService AluguelsService;

    public AluguelControllerV2(AluguelService aluguelService) {
        this.AluguelsService = aluguelService;
    }

    @GetMapping()
    public ResponseEntity<List<Aluguel>> findAllAlugueis(
            @RequestParam("size") int size,
            @RequestParam("page") int page) {
        log.info("Buscando todos os Aluguels");
        var aluguel = this.AluguelsService.findAllAlugueis(size, page);
        return ResponseEntity.ok(aluguel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluguel>> findAluguel(@PathVariable Long id) {
        log.info("Buscando Aluguel com id {}", id);
        var aluguel = this.AluguelsService.findAluguelById(id);
        return ResponseEntity.ok(aluguel);
    }

    @PostMapping
    public ResponseEntity<Void> savePessoa(@RequestBody @Valid AluguelRequestDTO aluguel) {
        log.info("Salvando Pessoa {}", aluguel);
        this.AluguelsService.saveAluguel(aluguel);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePessoa(@RequestBody AluguelRequestDTO aluguel, @PathVariable Long id) {
        log.info("Atualizando Pessoa {}", aluguel);
        this.AluguelsService.updateAluguel(aluguel, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        log.info("Deletando Pessoa com id {}", id);
        this.AluguelsService.deleteAluguel(id);
        return ResponseEntity.ok().build();
    }
    
}
