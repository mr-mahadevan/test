package com.sago.payment.controller;

import com.sago.payment.dto.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @PostMapping
    public ResponseEntity<UserRequest> saveUser(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.ok(userRequest);
    }
}
