package io.crcell.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
@ComponentScan("io.crcell")
public class DemoEventableProducerApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoEventableProducerApplication.class, args);
  }

}
