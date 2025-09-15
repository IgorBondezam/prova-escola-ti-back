package com.igor.escolaTI.controller;

import com.igor.escolaTI.domain.Veiculo;
import com.igor.escolaTI.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @PostMapping
    public ResponseEntity<Veiculo> createVeiculo(@RequestBody Veiculo veiculo) {
        return ResponseEntity.status(201).body(service.createVeiculo(veiculo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> updateVeiculo(@PathVariable("id") Long id, @RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(service.updateVeiculo(id, veiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/adicionar-acessorio/{acessorioId}")
    public ResponseEntity<Veiculo> adicionarAcessorio(@PathVariable("id") Long id, @PathVariable("acessorioId") Long acessorioId) {
        return ResponseEntity.ok(service.addAcessorio(id, acessorioId));
    }

    @PatchMapping("/{id}/remover-acessorio/{acessorioId}")
    public ResponseEntity<Veiculo> removerAcessorio(@PathVariable("id") Long id, @PathVariable("acessorioId") Long acessorioId) {
        return ResponseEntity.ok(service.removeAcessorio(id, acessorioId));
    }
}
