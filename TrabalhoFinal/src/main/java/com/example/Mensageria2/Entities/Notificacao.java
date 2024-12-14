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
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idAlertaClimatico;
    private String mensagem;
    private String destinatario;
    private LocalDateTime dataEnvio;

    @Override
    public String toString() {
        return "Notificacao{" +
                "id=" + id +
                ", idAlertaClimatico=" + idAlertaClimatico +
                ", mensagem='" + mensagem + '\'' +
                ", destinatario='" + destinatario + '\'' +
                ", dataEnvio=" + dataEnvio +
                '}';
    }
}
