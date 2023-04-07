package dev.abhishek.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import dev.abhishek.mvc.models.User;
public interface UserRepository extends CrudRepository<User, Integer> {

}
