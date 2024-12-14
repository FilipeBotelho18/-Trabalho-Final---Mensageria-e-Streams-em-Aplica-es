package com.example.Mensageria2.MensageriJavaFx;


import com.example.Mensageria2.Entities.AlertaClimatico;
import com.example.Mensageria2.Entities.CidadeMonitorada;
import com.example.Mensageria2.Entities.Notificacao;
import com.example.Mensageria2.Services.AlertaClimaticoService;
import com.example.Mensageria2.Services.CidadeMonitoradaService;
import com.example.Mensageria2.Services.NotificacaoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class MensagemController {

    private final AlertaClimaticoService alertaService;
    private final CidadeMonitoradaService cidadeService;
    private final NotificacaoService notificacaoService;

    public MensagemController(AlertaClimaticoService alertaService,
                              CidadeMonitoradaService cidadeService,
                              NotificacaoService notificacaoService) {
        this.alertaService = alertaService;
        this.cidadeService = cidadeService;
        this.notificacaoService = notificacaoService;
    }

    @FXML
    private TableView<AlertaClimatico> tabelaAlertas;

    @FXML
    private TableView<CidadeMonitorada> tabelaCidades;

    @FXML
    private TableView<Notificacao> tabelaNotificacoes;

    @FXML
    private ComboBox<String> cmbNivelSeveridade;

    @FXML
    public void initialize() {
        cmbNivelSeveridade.getItems().addAll("Baixa", "Moderada", "Alta", "Crítica");
        carregarDadosTabelas();
    }

    private void carregarDadosTabelas() {
        // Carregar alertas climáticos
        List<AlertaClimatico> alertas = alertaService.listarAlertas();
        tabelaAlertas.setItems(FXCollections.observableArrayList(alertas));

        // Carregar cidades monitoradas
        List<CidadeMonitorada> cidades = cidadeService.listarCidades();
        tabelaCidades.setItems(FXCollections.observableArrayList(cidades));

        // Carregar notificações
        List<Notificacao> notificacoes = notificacaoService.listarNotificacoes();
        tabelaNotificacoes.setItems(FXCollections.observableArrayList(notificacoes));
    }

    public void enviarMensagem(ActionEvent actionEvent) {
    }
}
