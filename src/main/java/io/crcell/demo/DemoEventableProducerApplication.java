package io.crcell.demo;

import io.crcell.pramework.eventable.producer.EnableProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableProducer
@SpringBootApplication
public class DemoEventableProducerApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoEventableProducerApplication.class, args);
  }

}
