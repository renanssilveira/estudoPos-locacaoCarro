package com.estudo.pos.locatech.controllers;

import com.estudo.pos.locatech.entities.Veiculo;
import com.estudo.pos.locatech.services.VeiculosService;
import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/veiculos")
@Tag(name = "Veiculos", description = "Gerenciamento de Veiculos")
public class VeiculoController {


    private final VeiculosService veiculosService;

    public VeiculoController(VeiculosService veiculosService) {
        this.veiculosService = veiculosService;
    }

    @Operation(
            description = "Buscar todos os veiculos",
            summary = "Buscar todos os veiculos")

    @GetMapping()
    public ResponseEntity<List<Veiculo>> findAllVeiculos(
            @RequestParam("size") int size,
            @RequestParam("page") int page) {
        log.info("Buscando todos os veiculos");
        var veiculos = this.veiculosService.findAllVeiculo(size, page);
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> findVeiculo(@PathVariable Long id) {
        log.info("Buscando veiculo com id {}", id);
        var veiculo = this.veiculosService.findVeiculoById(id);
        return ResponseEntity.ok(veiculo);
    }

    @PostMapping
    public ResponseEntity<Void> saveVeiculo(@RequestBody Veiculo veiculo) {
        log.info("Salvando veiculo {}", veiculo);
        this.veiculosService.saveVeiculo(veiculo);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVeiculo(@RequestBody Veiculo veiculo, @PathVariable Long id) {
        log.info("Atualizando veiculo {}", veiculo);
        this.veiculosService.updateVeiculo(veiculo, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable Long id) {
        log.info("Deletando veiculo com id {}", id);
        this.veiculosService.deleteVeiculo(id);
        return ResponseEntity.ok().build();
    }

}
