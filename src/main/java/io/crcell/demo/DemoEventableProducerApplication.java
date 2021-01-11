package io.crcell.demo;

import io.crcell.pramework.eventable.EnableEventable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableEventable
@SpringBootApplication
public class DemoEventableProducerApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoEventableProducerApplication.class, args);
  }

}
