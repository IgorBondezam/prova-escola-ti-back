package com.igor.escolaTI.service;

import com.igor.escolaTI.domain.Acessorio;
import com.igor.escolaTI.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcessorioService {

    @Autowired
    private AcessorioRepository repository;

    public Acessorio createAcessorio(Acessorio acessorio) {
        return repository.save(acessorio);
    }

    public Acessorio findById(Long id){
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id não encontrado"));
    }

    public List<Acessorio> findAll() {
        return repository.findAll();
    }

    public Acessorio updateAcessorio(Long id, Acessorio acessorio) {
        Acessorio acessorioAtualizado = findById(id);
        acessorioAtualizado.setNome(acessorio.getNome());
        return repository.save(acessorioAtualizado);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}