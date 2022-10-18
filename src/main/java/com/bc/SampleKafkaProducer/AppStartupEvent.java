package com.bc.SampleKafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {


//    @Autowired
//    KafkaTemplate<String, String> kafkaTemplate;
//
//    String TOPIC = "health";
//    String message = "everything is O.K.";
//
//    @Scheduled(cron = "*/3 * * * *")
//    public void produce() {
//        kafkaTemplate.send(TOPIC, message);
//    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("APPLICATION STARTUP EVENT");

        //produce();
    }
}
