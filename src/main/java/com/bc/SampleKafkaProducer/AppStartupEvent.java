package com.bc.SampleKafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Date;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    private KafkaProducerService kafkaProducerService;


    @Scheduled(cron = "*/1 * * * *")
    public void produce() {
        String d = new Date().toString();
        kafkaProducerService.sendMessage("kafka message sent at " + d);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("APPLICATION STARTUP EVENT");
        String d = new Date().toString();
        kafkaProducerService.sendMessage("kafka message sent at " + d);

        produce();
    }
}
