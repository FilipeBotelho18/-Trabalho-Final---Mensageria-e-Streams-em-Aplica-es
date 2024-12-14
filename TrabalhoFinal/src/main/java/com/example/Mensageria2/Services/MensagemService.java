package com.example.Mensageria2.Services;

import com.example.Mensageria2.DTO.MensagemDTO;
import com.example.Mensageria2.Entities.AlertaClimatico;
import com.example.Mensageria2.Entities.CidadeMonitorada;
import com.example.Mensageria2.Entities.Notificacao;
import com.example.Mensageria2.Persistence.AlertaClimaticoRepository;
import com.example.Mensageria2.Persistence.CidadeMonitoradaRepository;
import com.example.Mensageria2.Persistence.MensagemRepository;
import com.example.Mensageria2.Persistence.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;

    @Autowired
    private AlertaClimaticoRepository alertaClimaticoRepository;

    @Autowired
    private CidadeMonitoradaRepository cidadeMonitoradaRepository;

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Transactional
    public void salvarMensagem(MensagemDTO mensagemDto) {
        // Salva a mensagem no banco de dados
        MensagemDTO mensagemSalva = mensagemRepository.save(mensagemDto);

        // Cria e salva o alerta climático associado à mensagem
        AlertaClimatico alertaClimatico = new AlertaClimatico();
        alertaClimatico.setTipoAlerta("Alerta Meteorológico");
        alertaClimatico.setDescricao("Alerta para a cidade de " + mensagemDto.getEstado());
        alertaClimatico.setCidadeMonitorada(mensagemDto.getNome());
        alertaClimatico.setDataEmissao(LocalDateTime.now());
        alertaClimaticoRepository.save(alertaClimatico);

        // Cria e salva a cidade monitorada associada ao alerta
        CidadeMonitorada cidadeMonitorada = new CidadeMonitorada();
        cidadeMonitorada.setDescricao(mensagemDto.getDescricao());
        cidadeMonitorada.setEstado(mensagemDto.getEstado());
        cidadeMonitorada.setNivelSeveridade(mensagemDto.getNivelSeveridade());
        cidadeMonitorada.setNome(mensagemDto.getNome());
        cidadeMonitorada.setTipoEvento(mensagemDto.getTipoEvento());
        cidadeMonitorada.setLatitude(mensagemDto.getLatitude());
        cidadeMonitorada.setLongitude(mensagemDto.getLongitude());
        cidadeMonitoradaRepository.save(cidadeMonitorada);

        // Cria e salva a notificação associada ao alerta
        Notificacao notificacao = new Notificacao();
        notificacao.setIdAlertaClimatico(alertaClimatico.getId());
        notificacao.setMensagem("Alerta de " + alertaClimatico.getTipoAlerta() + " para " + cidadeMonitorada.getNome());
        notificacao.setDestinatario("Autoridades locais");
        notificacao.setDataEnvio(LocalDateTime.now());
        notificacaoRepository.save(notificacao);

        System.out.println("Mensagem, Alerta, Cidade e Notificação salvos com sucesso.");
    }
}
