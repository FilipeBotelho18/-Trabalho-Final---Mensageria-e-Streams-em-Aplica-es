package com.example.Mensageria2.Services;

import com.example.Mensageria2.Entities.AlertaClimatico;
import com.example.Mensageria2.Persistence.AlertaClimaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlertaClimaticoService {

    @Autowired
    private AlertaClimaticoRepository alertaClimaticoRepository;

    public AlertaClimatico salvarAlerta(AlertaClimatico alerta) {
        return alertaClimaticoRepository.save(alerta);
    }

    public List<AlertaClimatico> listarAlertas() {
        return alertaClimaticoRepository.findAll();
    }

    public AlertaClimatico buscarAlertaPorId(Long id) {
        return alertaClimaticoRepository.findById(id).orElse(null);
    }
}
