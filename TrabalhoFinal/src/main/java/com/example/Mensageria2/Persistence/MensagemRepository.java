package com.example.Mensageria2.Persistence;

import com.example.Mensageria2.DTO.MensagemDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<MensagemDTO, Long> {
}
