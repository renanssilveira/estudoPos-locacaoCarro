package com.estudo.pos.locatech.entities;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class Veiculo {
    
    private Long id;
    
    private String marca;
    
    private String modelo;
    
    private String placa;
    
    private int ano;
    
    private String cor;
    
    private BigDecimal valorDiaria;
    
    
}
