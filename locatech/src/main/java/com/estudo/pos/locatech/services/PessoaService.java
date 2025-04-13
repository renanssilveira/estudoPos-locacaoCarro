package com.estudo.pos.locatech.services;


import com.estudo.pos.locatech.entities.Pessoa;
import com.estudo.pos.locatech.repositories.PessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository PessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        PessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAllPessoa(int size, int page) {
        int offset = (page - 1) * size;
        return this.PessoaRepository.findAll(size, offset);
    }

    public Optional<Pessoa> findPessoaById(Long id) {
        return this.PessoaRepository.findById(id);
    }

    public void savePessoa(Pessoa Pessoa) {
        var save = this.PessoaRepository.Save(Pessoa);
        Assert.state(save == 1, "Erro ao salvar Pessoa " + Pessoa.getNome());
    }

    public void updatePessoa(Pessoa Pessoa, Long id) {
        var update = this.PessoaRepository.update(Pessoa, id);
        if (update == 0) {
            throw new RuntimeException("Erro ao atualizar Pessoa " + Pessoa.getNome());
        }
    }

    public void deletePessoa(Long id) {
        var delete = this.PessoaRepository.delete(id);
        if (delete == 0) {
            throw new RuntimeException("Erro ao deletar Pessoa com id " + id);
        }
    }

}
