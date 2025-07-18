package com.sago.payment.controller;

import com.sago.payment.dto.UserRequest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;

@SpringBootTest
@WebMvcTest(UserController.class)
class UserControllerTest {

    @org.junit.jupiter.api.Test
    void saveUser() {
    }
}