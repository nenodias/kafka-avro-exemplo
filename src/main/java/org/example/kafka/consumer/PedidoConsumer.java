package org.example.kafka.consumer;

import org.example.kafka.KafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PedidoConsumer {

    @KafkaListener(
            id = KafkaConstants.CLIENT_ID,
            topics = KafkaConstants.TOPIC_NAME
    )
    public void listen(org.example.avro.model.PedidoAvro message) {
        log.info( "Mensagem recebida='{}'", message);
    }
}
