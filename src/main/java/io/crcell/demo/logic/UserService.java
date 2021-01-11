package io.crcell.demo.logic;

import io.crcell.demo.entities.User;
import io.crcell.demo.entities.store.UserRepository;
import io.crcell.pramework.serviceable.ServiceableImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService extends ServiceableImpl<User, Long> {
  public UserService(UserRepository repository) {
    super(repository);
  }
}
