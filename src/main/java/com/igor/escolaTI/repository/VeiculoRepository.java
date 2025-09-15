package com.igor.escolaTI.repository;

import com.igor.escolaTI.domain.Acessorio;
import com.igor.escolaTI.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
