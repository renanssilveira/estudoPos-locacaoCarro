package com.estudo.pos.locatech.repositories;

import com.estudo.pos.locatech.entities.Pessoa;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaRepositoryImp implements PessoaRepository{

    private final JdbcClient jdbcClient;

    public PessoaRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    @Override
    public Optional<Pessoa> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT * FROM pessoas WHERE id = :id")
                .param("id", id)
                .query(Pessoa.class)
                .optional();
    }

    @Override
    public List<Pessoa> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM pessoas limit :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Pessoa.class)
                .list();
    }

    @Override
    public Integer Save(Pessoa pessoa) {
        return this.jdbcClient
                .sql("INSERT INTO pessoas (nome, cpf, telefone, email) VALUES (:nome, :cpf, :telefone, :email)")
                .param("nome", pessoa.getNome())
                .param("cpf", pessoa.getCpf())
                .param("telefone", pessoa.getTelefone())
                .param("email", pessoa.getEmail())
                .update();
    }

    @Override
    public Integer update(Pessoa pessoa, Long id) {
        return this.jdbcClient
                .sql("UPDATE pessoas set nome = :nome , cpf = :cpf, telefone = :telefone, email = :email")
                .param("nome", pessoa.getNome())
                .param("cpf", pessoa.getCpf())
                .param("telefone", pessoa.getTelefone())
                .param("email", pessoa.getEmail())
                .param("id", id)
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient.sql("delete from pessoas where id = :id")
                .param("id", id)
                .update();
    }
}
