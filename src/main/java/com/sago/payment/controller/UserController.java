package com.sago.payment.controller;

import com.sago.payment.dto.UserRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping(value = "api/users")
public class UserController {


    @PostMapping(
            name = "Save User",
            value = "/save",
            produces = "application/json",
            consumes = "application/json",
            headers = "Content-Type=application/json")
    public ResponseEntity<UserRequest> saveUser(@RequestBody @Valid UserRequest userRequest, HttpServletRequest request){
        log.info("User IP: {}" , request.getRemoteAddr());
        return ResponseEntity.ok(userRequest);
    }
}
