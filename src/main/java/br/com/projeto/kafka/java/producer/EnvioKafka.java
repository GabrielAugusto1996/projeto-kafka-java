package br.com.projeto.kafka.java.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class EnvioKafka {

    public static void main(String[] args) {
        final Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());


        try (final KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties)) {
            final ProducerRecord<String, String> record = new ProducerRecord<>("testejava", "Hello World");

            kafkaProducer.send(record);
        }
    }
}
