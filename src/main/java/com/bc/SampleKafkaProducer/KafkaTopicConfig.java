package com.bc.SampleKafkaProducer;


import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * this class is used to externalize the configuration of topics within your kafka cluster
 * for multiple topics, provide an array of string values for topics in application.yml and
 * refactor createTopic method to deal with a dynamically sized array
 * */

@Configuration
public class KafkaTopicConfig {

//    @Value(value = "${spring.kafka.bootstrap-servers}")
//    private String bootstrapAddress;
    private String bootstrapAddress = "kafka:9092";

//    @Value(value = "${spring.kafka.topic.name}")
//    private String kafkaTopic;
    private String kafkaTopic = "primary";

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic createTopic() {
        return new NewTopic(kafkaTopic, 1, (short) 1);
    }
}
