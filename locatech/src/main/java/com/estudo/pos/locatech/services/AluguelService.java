package com.estudo.pos.locatech.services;

import com.estudo.pos.locatech.entities.Aluguel;
import com.estudo.pos.locatech.repositories.AluguelRespository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class AluguelService {

    private final AluguelRespository aluguelRespository;

    public AluguelService(AluguelRespository aluguelRespository) {
        this.aluguelRespository = aluguelRespository;
    }

    public List<Aluguel> findAllAlugueis(int size, int page) {
        int offset = (page - 1) * size;
        return this.aluguelRespository.findAll(size, offset);
    }

    public Optional<Aluguel> findAluguelById(Long id) {
        return this.aluguelRespository.findById(id);
    }

    public void saveAluguel(Aluguel aluguel) {
        var save = this.aluguelRespository.Save(aluguel);
        Assert.state(save == 1, "Erro ao salvar Aluguel " + aluguel.getPessoaNome());
    }

    public void updateAluguel(Aluguel aluguel, Long id) {
        var update = this.aluguelRespository.update(aluguel, id);
        if (update == 0) {
            throw new RuntimeException("Erro ao atualizar Aluguel " + aluguel.getPessoaNome());
        }
    }

    public void deleteAluguel(Long id) {
        var delete = this.aluguelRespository.delete(id);
        if (delete == 0) {
            throw new RuntimeException("Erro ao deletar Aluguel com id " + id);
        }
    }
}
