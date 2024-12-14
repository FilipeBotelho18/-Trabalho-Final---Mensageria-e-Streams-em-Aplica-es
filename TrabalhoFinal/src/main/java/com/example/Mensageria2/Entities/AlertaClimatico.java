package com.example.Mensageria2.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class AlertaClimatico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoAlerta;
    private String descricao;
    private String cidadeMonitorada;
    private LocalDateTime dataEmissao;

    @Override
    public String toString() {
        return "AlertaClimatico{" +
                "id=" + id +
                ", tipoAlerta='" + tipoAlerta + '\'' +
                ", descricao='" + descricao + '\'' +
                ", cidadeMonitorada='" + cidadeMonitorada + '\'' +
                ", dataEmissao=" + dataEmissao +
                '}';
    }
}
