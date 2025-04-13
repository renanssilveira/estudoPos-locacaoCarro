package com.estudo.pos.locatech.repositories;

import com.estudo.pos.locatech.entities.Aluguel;

import java.util.List;
import java.util.Optional;

public interface AluguelRespository {

    Optional<Aluguel> findById(Long id);

    List<Aluguel> findAll(int size, int offset);

    Integer Save(Aluguel Aluguel);

    Integer update(Aluguel Aluguel, Long id);

    Integer delete(Long id);


}
