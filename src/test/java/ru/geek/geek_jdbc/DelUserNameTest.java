package ru.geek.geek_jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ru.geek.geek_jdbc.repository.UserRepository;

import javax.jws.soap.SOAPBinding;

import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DelUserNameTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    void deletelUserName(){
        List <User> delUser = userRepository.deleteUserByNameEquals("Natasha");
        Assertions.assertEquals(1,delUser.size());
    }

}