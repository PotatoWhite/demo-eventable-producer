package io.crcell.demo.logic;

import io.crcell.demo.entities.User;
import io.crcell.demo.entities.store.UserRepository;
import io.crcell.pramework.serviceable.ServiceableImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService extends ServiceableImpl<User, Long> {
  private final UserRepository userRepository;

  public UserService(UserRepository repository) {
    super(repository);
    this.userRepository = repository;
  }


  public List<User> findAll() {
    return userRepository.findAll();
  }
}
