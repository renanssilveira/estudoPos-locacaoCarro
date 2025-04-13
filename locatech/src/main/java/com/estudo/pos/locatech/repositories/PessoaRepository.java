package com.estudo.pos.locatech.repositories;

import com.estudo.pos.locatech.entities.Pessoa;
import java.util.List;
import java.util.Optional;

public interface PessoaRepository {

    Optional<Pessoa> findById(Long id);

    List<Pessoa> findAll(int size, int offset);

    Integer Save(Pessoa pessoa);

    Integer update(Pessoa pessoa, Long id);

    Integer delete(Long id);

}
