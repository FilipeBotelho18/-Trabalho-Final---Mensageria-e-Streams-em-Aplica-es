package com.example.Mensageria2.Services;

import com.example.Mensageria2.Entities.CidadeMonitorada;
import com.example.Mensageria2.Persistence.CidadeMonitoradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CidadeMonitoradaService {

    @Autowired
    private CidadeMonitoradaRepository cidadeMonitoradaRepository;

    public CidadeMonitorada salvarCidade(CidadeMonitorada cidade) {
        return cidadeMonitoradaRepository.save(cidade); // .save() para salvar no banco
    }

    public List<CidadeMonitorada> listarCidades() {
        return cidadeMonitoradaRepository.findAll(); // .findAll() para listar todas as cidades
    }

    public CidadeMonitorada buscarCidadePorId(Long id) {
        return cidadeMonitoradaRepository.findById(id).orElse(null); // .findById() para buscar por ID
    }
}
