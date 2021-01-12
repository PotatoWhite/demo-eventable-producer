package io.crcell.demo.expose;

import io.crcell.demo.entities.User;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserListener extends ListenerImpl<User> {
  public UserListener() {
    super(User.class.getName());
  }
}
