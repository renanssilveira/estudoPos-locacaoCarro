package com.estudo.pos.locatech.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AluguelRequestDTO(

        @NotNull(message = "O id do veículo não pode ser nulo")
        Long veiculoId,

        @NotNull(message = "O id da pessoa não pode ser nulo")
        Long pessoaId,

        LocalDate dataInicio,

        LocalDate dataFim
        ) {}
