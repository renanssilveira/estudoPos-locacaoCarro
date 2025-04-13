package com.estudo.pos.locatech.repositories;

import com.estudo.pos.locatech.entities.Veiculo;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VeiculoRepositoryImp implements VeiculoRepository{

    private final JdbcClient jdbcClient;

    public VeiculoRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    @Override
    public Optional<Veiculo> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT * FROM veiculos WHERE id = :id")
                .param("id", id)
                .query(Veiculo.class)
                .optional();
    }

    @Override
    public List<Veiculo> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM veiculos limit :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Veiculo.class)
                .list();
    }

    @Override
    public Integer Save(Veiculo veiculo) {
        return this.jdbcClient
                .sql("INSERT INTO veiculos (modelo, marca, placa, ano, cor, valor_diaria) VALUES (:modelo, :marca, :placa, :ano, :cor, :valor_diaria)")
                .param("modelo", veiculo.getModelo())
                .param("marca", veiculo.getMarca())
                .param("ano", veiculo.getAno())
                .param("cor", veiculo.getCor())
                .param("placa", veiculo.getPlaca())
                .param("valor_diaria", veiculo.getValorDiaria())
                .update();
    }

    @Override
    public Integer update(Veiculo veiculo, Long id) {
        return this.jdbcClient.sql("update veiculos set modelo = :modelo, marca = :marca, ano = :ano, cor = :cor, placa = :placa, valor_diaria = :valor_diaria where id = :id")
                .param("modelo", veiculo.getModelo())
                .param("marca", veiculo.getMarca())
                .param("ano", veiculo.getAno())
                .param("cor", veiculo.getCor())
                .param("placa", veiculo.getPlaca())
                .param("valor_diaria", veiculo.getValorDiaria())
                .param("id", id)
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient.sql("delete from veiculos where id = :id")
                .param("id", id)
                .update();
    }
}

