package com.bc.SampleKafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * this class is used to invoke some behavior to happen on startup, since this is a demo,
 * it will schedule a method to send a kafka message every second
 * */

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    public AppStartupEvent() {}

    @Value(value = "${spring.kafka.topic.name}")
    private String kafkaTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        System.out.println("sending message : " + kafkaTopic + " - " +msg);
        kafkaTemplate.send(kafkaTopic, msg);
    }

    /**
     * the @Scheduled annotation requires that the @EnableScheduling annotation
     * is either on a spring config class or on the main class itself along with
     * the @SpringBootApplication annotation. The scheduled method does not need to be invoked anywhere
     * */

    @Scheduled(cron = "*/10 * * * * *")
    public void produce() {
        long d = new Date().getTime();
        sendMessage("hello world " + d);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("APPLICATION STARTUP EVENT");
    }
}
