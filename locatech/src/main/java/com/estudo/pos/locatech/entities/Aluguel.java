package com.estudo.pos.locatech.entities;

import com.estudo.pos.locatech.dto.AluguelRequestDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Aluguel {

    private Long id;

    private Long veiculoId;

    private Long pessoaId;

    private String veiculoModelo;

    private String pessoaCpf;

    private String pessoaNome;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private BigDecimal valorTotal;

    public Aluguel(AluguelRequestDTO aluguelRequestDTO, BigDecimal valorTotal) {
        this.veiculoId = aluguelRequestDTO.veiculoId();
        this.pessoaId = aluguelRequestDTO.pessoaId();
        this.dataInicio = aluguelRequestDTO.dataInicio();
        this.dataFim = aluguelRequestDTO.dataFim();
        this.valorTotal = valorTotal;
    }

}
