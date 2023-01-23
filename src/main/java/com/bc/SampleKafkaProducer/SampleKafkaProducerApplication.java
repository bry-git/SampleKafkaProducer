package com.bc.SampleKafkaProducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * https://www.baeldung.com/spring-kafka
 * */

@EnableScheduling
@SpringBootApplication
public class SampleKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleKafkaProducerApplication.class, args);
	}

}
