package ru.geek.geek_jdbc.repository;

import ru.geek.geek_jdbc.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByAgeBetween(long minAge, long maxAge);

    List <User> deleteUserByNameEquals(String name);

}
