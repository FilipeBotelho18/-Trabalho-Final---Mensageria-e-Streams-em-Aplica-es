package com.example.Mensageria2.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MensagemDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Identificador único

    private String descricao;
    private String estado;
    private String nivelSeveridade;
    private String nome;
    private String tipoEvento;
    private Double latitude;
    private Double longitude;

    @Override
    public String toString() {
        return "MensagemDTO{" +
                "descricao='" + descricao + '\'' +
                ", estado='" + estado + '\'' +
                ", nivelSeveridade='" + nivelSeveridade + '\'' +
                ", nome='" + nome + '\'' +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
