package com.example.Mensageria2.Persistence;

import com.example.Mensageria2.Entities.CidadeMonitorada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeMonitoradaRepository extends JpaRepository<CidadeMonitorada, Long> {
}
