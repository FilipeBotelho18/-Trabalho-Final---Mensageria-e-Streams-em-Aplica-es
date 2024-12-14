package com.example.Mensageria2.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class CidadeMonitorada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String estado;
    private String nivelSeveridade;
    private String nome;
    private String tipoEvento;

    private Double latitude = 0.0;
    private Double longitude = 0.0;

    @Override
    public String toString() {
        return "CidadeMonitorada{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", estado='" + estado + '\'' +
                ", nivelSeveridade='" + nivelSeveridade + '\'' +
                ", nome='" + nome + '\'' +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
