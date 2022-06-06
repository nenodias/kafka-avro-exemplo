package org.example.kafka;

public interface KafkaConstants {
    public static String KAFKA_BROKERS = "http://localhost:9092";
    public static String CLIENT_ID = "pedidoClient";
    public static String TOPIC_NAME = "pedido";
    public static String GROUP_ID_CONFIG = "pedidoConsumerGroup";
    public static String OFFSET_RESET_EARLIER = "earliest";
    public static Integer MAX_POLL_RECORDS = 1;
    public static String ENABLE_AUTO_COMMIT_CONFIG = "false";
    public static String SCHEMA_REGISTRY_URL_CONFIG = "http://localhost:8081";
}
