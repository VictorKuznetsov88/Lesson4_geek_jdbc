package ru.geek.geek_jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class AddUserTest {

    @Autowired
    AddUser addUser;

    @Test
    void registerNewUser(){
        User newUser = addUser.registerNewUser("Nikolay",68L,"support4@mail.ru");
        Assertions.assertNotNull("Nikolay");


    }
}