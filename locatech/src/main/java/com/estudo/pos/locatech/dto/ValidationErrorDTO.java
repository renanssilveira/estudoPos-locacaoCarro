package com.estudo.pos.locatech.dto;

import java.util.List;

public record ValidationErrorDTO(List<String> errors, int status) {}
