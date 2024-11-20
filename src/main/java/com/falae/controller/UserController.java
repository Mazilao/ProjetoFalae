package com.falae.controller;


import com.falae.model.User;
import com.falae.service.dto.UserDTO;
import com.falae.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/register")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity getAllUsers(){
        var allUsers = userRepository.findAll();
        return ResponseEntity.ok(allUsers);
    }

    @PostMapping
    public ResponseEntity registerUser(@RequestBody UserDTO data){
        try {
            User newUser = new User(data);
            userRepository.save(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado com sucesso!");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Credenciais invalidas.");
        }

    }

}
