package org.example.kafka.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.example.kafka.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PedidoProducer {

    @Autowired
    private KafkaTemplate<Long, org.example.avro.model.PedidoAvro> template;

    public void sendAsync(org.example.avro.model.PedidoAvro pedido) {
        ProducerRecord<Long, org.example.avro.model.PedidoAvro> record = new ProducerRecord<Long, org.example.avro.model.PedidoAvro>(
                KafkaConstants.TOPIC_NAME, pedido);
        ListenableFuture<SendResult<Long, org.example.avro.model.PedidoAvro>> future = template.send(record);
        future.addCallback(new ListenableFutureCallback<SendResult<Long, org.example.avro.model.PedidoAvro>>() {
            @Override
            public void onSuccess(SendResult<Long, org.example.avro.model.PedidoAvro> result) {
                log.info( "Pedido enviado com sucesso!");
            }
            @Override
            public void onFailure(Throwable e) {
                log.error(e.getMessage(), e);
            }
        });
    }
}
