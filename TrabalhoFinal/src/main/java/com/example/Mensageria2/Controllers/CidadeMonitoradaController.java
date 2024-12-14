package com.example.Mensageria2.Controllers;

import com.example.Mensageria2.Entities.CidadeMonitorada;
import com.example.Mensageria2.Services.CidadeMonitoradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidades")
public class CidadeMonitoradaController {

    @Autowired
    private CidadeMonitoradaService cidadeMonitoradaService;

    @GetMapping
    public ResponseEntity<List<CidadeMonitorada>> listarCidades() {
        List<CidadeMonitorada> cidades = cidadeMonitoradaService.listarCidades();
        return ResponseEntity.ok(cidades);
    }

    @PostMapping
    public ResponseEntity<CidadeMonitorada> salvarCidade(@RequestBody CidadeMonitorada cidadeMonitorada) {
        CidadeMonitorada novaCidade = cidadeMonitoradaService.salvarCidade(cidadeMonitorada);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCidade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeMonitorada> buscarCidadePorId(@PathVariable Long id) {
        CidadeMonitorada cidade = cidadeMonitoradaService.buscarCidadePorId(id);
        if (cidade != null) {
            return ResponseEntity.ok(cidade);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
