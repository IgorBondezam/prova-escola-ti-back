package com.igor.escolaTI.service;

import com.igor.escolaTI.domain.Acessorio;
import com.igor.escolaTI.domain.Veiculo;
import com.igor.escolaTI.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private AcessorioService acessorioService;
    public Veiculo createVeiculo(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public Veiculo findById(Long id){
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id não encontrado"));
    }

    public List<Veiculo> findAll() {
        return repository.findAll();
    }

    public Veiculo updateVeiculo(Long id, Veiculo veiculo) {
        Veiculo veiculoAtualizado = findById(id);

        veiculoAtualizado.setModelo(veiculo.getModelo());
        veiculoAtualizado.setPlaca(veiculo.getPlaca());
        veiculoAtualizado.setAnoFabricacao(veiculo.getAnoFabricacao());

        return repository.save(veiculoAtualizado);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Veiculo addAcessorio(Long veiculoId, Long acessorioId) {
        Veiculo veiculo = findById(veiculoId);
        veiculo.addAcessorio(acessorioService.findById(acessorioId));
        return repository.save(veiculo);
    }

    public Veiculo removeAcessorio(Long veiculoId, Long acessorioId) {
        Veiculo veiculo = findById(veiculoId);
        veiculo.removeAcessorio(acessorioService.findById(acessorioId));
        return repository.save(veiculo);
    }
}
