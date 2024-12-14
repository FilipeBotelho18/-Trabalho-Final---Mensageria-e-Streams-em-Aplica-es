package com.example.Mensageria2;

import com.example.Mensageria2.DTO.MensagemDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    @Value("${queue.name}")
    private String queueAlertas;

    public Producer(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void enviarMensagemAlerta(MensagemDTO mensagemDTO) {
        try {
            String mensagemJson = objectMapper.writeValueAsString(mensagemDTO);
            rabbitTemplate.convertAndSend(queueAlertas, mensagemJson);
            System.out.println("Mensagem enviada para a fila: " + mensagemJson);
        } catch (Exception e) {
            System.err.println("Erro ao enviar mensagem: " + e.getMessage());
        }
    }

}
