package com.estudo.pos.locatech.entities;

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

}
