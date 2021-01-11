package io.crcell.demo.entities;

import io.crcell.demo.utils.JpaJsonConverter;
import io.crcell.pramework.eventable.Eventable;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Getter
@Setter
@Entity
@SecondaryTables({
                         @SecondaryTable(name = "user_contact"),
                         @SecondaryTable(name = "user_profile")
                 })
public class User implements Eventable<Long> {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Email
  @Column(unique = true)
  private String account;

  @NotNull
  @NotBlank
  private String name;

  // profile
  @Column(table = "user_profile")
  private String        nationality;
  @Column(table = "user_profile")
  private LocalDateTime birthdate;


  // contact
  @Column(table = "user_contact")
  private String mobile;
  @Column(table = "user_contact")
  private String email;
  @Column(table = "user_contact")
  private String work;


  @Convert(converter = JpaJsonConverter.class)
  private List<Address> addresses;

  @PrePersist
  private void setExtra() {
    if(email == null) email = account;
  }

}
