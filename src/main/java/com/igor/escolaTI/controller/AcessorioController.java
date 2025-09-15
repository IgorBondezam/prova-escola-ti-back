package com.igor.escolaTI.controller;


import com.igor.escolaTI.domain.Acessorio;
import com.igor.escolaTI.service.AcessorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acessorios")
public class AcessorioController {

    @Autowired
    private AcessorioService service;

    @PostMapping
    public ResponseEntity<Acessorio> createAcessorio(@RequestBody Acessorio acessorio) {
        return ResponseEntity.ok(service.createAcessorio(acessorio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acessorio> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Acessorio>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acessorio> updateAcessorio(@PathVariable("id") Long id, @RequestBody Acessorio acessorio) {
        return ResponseEntity.ok(service.updateAcessorio(id, acessorio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
