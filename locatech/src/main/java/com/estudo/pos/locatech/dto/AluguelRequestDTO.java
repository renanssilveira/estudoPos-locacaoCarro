package com.estudo.pos.locatech.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record AluguelRequestDTO(


        @Schema(description = "ID do veículo", example = "1")
        @NotNull(message = "O id do veículo não pode ser nulo")
        Long veiculoId,

        @Schema(description = "ID da pessoa", example = "1")
        @NotNull(message = "O id da pessoa não pode ser nulo")
        Long pessoaId,

        LocalDate dataInicio,

        LocalDate dataFim
        ) {}
