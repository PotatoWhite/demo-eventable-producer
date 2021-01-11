package io.crcell.demo.expose;

import io.crcell.demo.entities.User;
import io.crcell.demo.logic.UserService;
import io.crcell.pramework.controllable.ControllableImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController extends ControllableImpl<User, Long> {
  private final UserService userService;

  public UserController(UserService userService) {
    super(userService);
    this.userService = userService;
  }

  @GetMapping
  private ResponseEntity findAll() {
    return ResponseEntity.status(HttpStatus.OK)
                         .body(userService.findAll());
  }
}
