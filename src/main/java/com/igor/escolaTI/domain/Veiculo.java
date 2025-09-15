package com.igor.escolaTI.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String modelo;

    private Integer anoFabricacao;

    private String placa;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "veiculo_id", referencedColumnName = "id")
    private List<Acessorio> acessorios;

    public void addAcessorio(Acessorio item) {
        acessorios.add(item);
    }

    public void removeAcessorio(Acessorio item) {
        acessorios.remove(item);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
