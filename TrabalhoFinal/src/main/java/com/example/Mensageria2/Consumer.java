package com.example.Mensageria2;

import com.example.Mensageria2.DTO.MensagemDTO;
import com.example.Mensageria2.Persistence.MensagemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private final ObjectMapper objectMapper;
    private final MensagemRepository mensagemRepository;  // Repositório para salvar as mensagens

    public Consumer(ObjectMapper objectMapper, MensagemRepository mensagemRepository) {
        this.objectMapper = objectMapper;
        this.mensagemRepository = mensagemRepository;
    }

    @RabbitListener(queues = "mensageria_clima", ackMode = "MANUAL")
    public void receberMensagem(String mensagemJson, Message message, Channel channel) {
        try {
            // Deserializar a mensagem JSON
            MensagemDTO mensagemDTO = objectMapper.readValue(mensagemJson, MensagemDTO.class);
            System.out.println("Mensagem recebida: " + mensagemDTO);

            // Salvar no banco de dados
            mensagemRepository.save(mensagemDTO);  // Salvar diretamente a MensagemDTO no banco
            System.out.println("Mensagem salva no banco de dados.");

            // Confirmar a mensagem manualmente após o processamento
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            System.out.println("Mensagem confirmada com sucesso.");

        } catch (Exception e) {
            System.err.println("Erro ao processar mensagem: " + e.getMessage());
            try {
                // Se ocorrer um erro, rejeitar a mensagem (não colocar de volta na fila)
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
                System.err.println("Mensagem rejeitada com falha.");

            } catch (Exception ex) {
                System.err.println("Erro ao rejeitar mensagem: " + ex.getMessage());
            }
        }
    }
}
