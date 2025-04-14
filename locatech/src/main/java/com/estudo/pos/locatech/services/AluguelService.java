package com.estudo.pos.locatech.services;

import com.estudo.pos.locatech.dto.AluguelRequestDTO;
import com.estudo.pos.locatech.entities.Aluguel;
import com.estudo.pos.locatech.entities.Veiculo;
import com.estudo.pos.locatech.repositories.AluguelRespository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.estudo.pos.locatech.repositories.VeiculoRepository;
import com.estudo.pos.locatech.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class AluguelService {

    private final AluguelRespository aluguelRespository;

    private final VeiculoRepository veiculoRepository;

    public AluguelService(AluguelRespository aluguelRespository, VeiculoRepository veiculoRepository) {
        this.aluguelRespository = aluguelRespository;
        this.veiculoRepository = veiculoRepository;
    }

    public List<Aluguel> findAllAlugueis(int size, int page) {
        int offset = (page - 1) * size;
        return this.aluguelRespository.findAll(size, offset);
    }

    public Optional<Aluguel> findAluguelById(Long id) {
    return Optional.ofNullable(this.aluguelRespository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Aluguel não encontrado")));
    }

    public void saveAluguel(AluguelRequestDTO aluguel) {
        var aluguelEntity = calculaAluguel(aluguel);
        var save = this.aluguelRespository.Save(aluguelEntity);
        Assert.state(save == 1, "Erro ao salvar Aluguel " + aluguel.pessoaId());
    }

    public void updateAluguel(AluguelRequestDTO aluguel, Long id) {
        var aluguelEntity = calculaAluguel(aluguel);

        var update = this.aluguelRespository.update(aluguelEntity, id);
        if (update == 0) {
            throw new RuntimeException("Erro ao atualizar Aluguel " + aluguel.pessoaId());
        }
    }

    public void deleteAluguel(Long id) {
        var delete = this.aluguelRespository.delete(id);
        if (delete == 0) {
            throw new RuntimeException("Erro ao deletar Aluguel com id " + id);
        }
    }

    private Aluguel calculaAluguel(AluguelRequestDTO aluguel) {
        var veiculo = veiculoRepository.findById(aluguel.veiculoId()).orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        var quantidadeDias = BigDecimal.valueOf(aluguel.dataFim().getDayOfYear() - aluguel.dataInicio().getDayOfYear());
        var valorTotal = veiculo.getValorDiaria().multiply(quantidadeDias);

        return new Aluguel(aluguel, valorTotal);
    }
}
