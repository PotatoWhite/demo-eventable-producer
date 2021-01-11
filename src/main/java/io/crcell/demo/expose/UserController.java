package io.crcell.demo.expose;

import io.crcell.demo.entities.User;
import io.crcell.demo.logic.UserService;
import io.crcell.pramework.controllable.ControllableImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController extends ControllableImpl<User, Long> {
  public UserController(UserService userService) {
    super(userService);
  }
}
