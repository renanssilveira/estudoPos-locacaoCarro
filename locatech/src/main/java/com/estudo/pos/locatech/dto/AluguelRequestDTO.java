package com.estudo.pos.locatech.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AluguelRequestDTO(Long id, Long veiculoId, Long pessoaId, LocalDate dataInicio, LocalDate dataFim, BigDecimal valor) {}
