package com.example.Mensageria2.Services;

import com.example.Mensageria2.Entities.Notificacao;
import com.example.Mensageria2.Persistence.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public Notificacao salvarNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public List<Notificacao> listarNotificacoes() {
        return notificacaoRepository.findAll();
    }

    public Notificacao buscarNotificacaoPorId(Long id) {
        return notificacaoRepository.findById(id).orElse(null);
    }
}
