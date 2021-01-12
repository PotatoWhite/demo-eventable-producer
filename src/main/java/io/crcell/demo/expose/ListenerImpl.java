package io.crcell.demo.expose;

import io.crcell.pramework.eventable.EventableEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import javax.persistence.MappedSuperclass;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@MappedSuperclass
public abstract class ListenerImpl<T> {
  protected String topicName;
  @Value("${spring.application.name}")
  private String groupId;

  public ListenerImpl(String topicName) {
    this.topicName = topicName;
  }


  @Bean
  public void messageListenerContainer() {
    log.info("Start auto");
    ContainerProperties containerProps = new ContainerProperties(topicName);

    containerProps.setMessageListener((MessageListener<String, EventableEntity<T>>) message -> {
      log.info("received: {}", message.value()
                                      .getPayload());
    });
    KafkaMessageListenerContainer<String, EventableEntity<T>> container = createContainer(containerProps);
    container.setBeanName("testAuto");
    container.start();

  }


  private KafkaMessageListenerContainer<String, EventableEntity<T>> createContainer(ContainerProperties containerProps) {
    Map<String, Object>                                       props     = consumerProps();
    DefaultKafkaConsumerFactory<String, EventableEntity<T>>   cf        = new DefaultKafkaConsumerFactory<>(props);
    KafkaMessageListenerContainer<String, EventableEntity<T>> container = new KafkaMessageListenerContainer<String, EventableEntity<T>>(cf, containerProps);

    return container;
  }

  private Map<String, Object> consumerProps() {

    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
    props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
    props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    props.put(JsonDeserializer.TRUSTED_PACKAGES, "io.crcell.pramework.eventable");

    return props;
  }

}
