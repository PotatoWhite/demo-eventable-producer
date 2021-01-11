package io.crcell.demo.entities.store;


import io.crcell.demo.entities.User;
import io.crcell.pramework.eventable.repository.EventableRepository;

public interface UserRepository extends EventableRepository<User, Long> {

}
