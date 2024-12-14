package com.example.Mensageria2.Controllers;

import com.example.Mensageria2.Entities.Notificacao;
import com.example.Mensageria2.Services.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @GetMapping
    public ResponseEntity<List<Notificacao>> listarNotificacoes() {
        List<Notificacao> notificacoes = notificacaoService.listarNotificacoes();
        return ResponseEntity.ok(notificacoes);
    }

    @PostMapping
    public ResponseEntity<Notificacao> salvarNotificacao(@RequestBody Notificacao notificacao) {
        Notificacao novaNotificacao = notificacaoService.salvarNotificacao(notificacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaNotificacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacao> buscarNotificacaoPorId(@PathVariable Long id) {
        Notificacao notificacao = notificacaoService.buscarNotificacaoPorId(id);
        if (notificacao != null) {
            return ResponseEntity.ok(notificacao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
