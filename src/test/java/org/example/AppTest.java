package org.example;

import org.example.kafka.producer.PedidoProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class AppTest 
{
    @Autowired
    private PedidoProducer producer;

    @Test
    void testProducer() {
        org.example.avro.model.PessoaAvro pessoa = org.example.avro.model.PessoaAvro.newBuilder()
                .setNome("Pedro").build();
        org.example.avro.model.ProdutoAvro produto = org.example.avro.model.ProdutoAvro.newBuilder()
                .setNome("Camiseta").build();
        org.example.avro.model.PedidoAvro pedido = org.example.avro.model.PedidoAvro.newBuilder()
                .setId(1)
                .setStatus(org.example.avro.model.StatusAvro.ENTREGUE)
                .setId(1l)
                .setPessoa(pessoa)
                .setProdutos(Collections.singletonList(produto)).build();
        producer.sendAsync(pedido);
    }
}
