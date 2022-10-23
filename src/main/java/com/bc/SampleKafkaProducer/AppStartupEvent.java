package com.bc.SampleKafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private KafkaProducerService kafkaProducerService;


    @Scheduled(cron = "*/1 * * * *")
    public void produce() {
        kafkaProducerService.sendMessage("kafka message");
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("APPLICATION STARTUP EVENT");

        kafkaProducerService.sendMessage("kafka message");

        produce();
    }
}
