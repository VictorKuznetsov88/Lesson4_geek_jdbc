package ru.geek.geek_jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import ru.geek.geek_jdbc.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;


@SpringBootTest
@Transactional
class GeekJdbcApplicationTests {


    @Autowired
    UserRepository userRepository;

    @Test
    void contextLoads() {
        User one = userRepository.getOne(2L);
        //List<User> all= userRepository.findAll();
        List<User> betweenAll = userRepository.findAllByAgeBetween(20L,40L);

        Assertions.assertEquals("Oleg",one.getName());
        Assertions.assertEquals(2,betweenAll.size());

    }

}
