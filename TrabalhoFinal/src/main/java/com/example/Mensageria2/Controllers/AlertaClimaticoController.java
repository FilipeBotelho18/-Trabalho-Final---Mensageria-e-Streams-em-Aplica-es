package com.example.Mensageria2.Controllers;

import com.example.Mensageria2.DTO.MensagemDTO;
import com.example.Mensageria2.Entities.AlertaClimatico;
import com.example.Mensageria2.Producer;
import com.example.Mensageria2.Services.AlertaClimaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas-climaticos")
public class AlertaClimaticoController {

    private final Producer producer;
    private final AlertaClimaticoService alertaClimaticoService;

    @Autowired
    public AlertaClimaticoController(Producer producer, AlertaClimaticoService alertaClimaticoService) {
        this.producer = producer;
        this.alertaClimaticoService = alertaClimaticoService;
    }

    @GetMapping
    public ResponseEntity<List<AlertaClimatico>> listarAlertas() {
        List<AlertaClimatico> alertas = alertaClimaticoService.listarAlertas();
        return ResponseEntity.ok(alertas);
    }

    @PostMapping
    public ResponseEntity<String> enviarAlerta(@RequestBody MensagemDTO mensagemDTO) {
        try {
            producer.enviarMensagemAlerta(mensagemDTO);
            return ResponseEntity.ok("Alerta enviado para a fila RabbitMQ!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao enviar alerta: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertaClimatico> buscarAlertaPorId(@PathVariable Long id) {
        AlertaClimatico alerta = alertaClimaticoService.buscarAlertaPorId(id);
        if (alerta != null) {
            return ResponseEntity.ok(alerta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
