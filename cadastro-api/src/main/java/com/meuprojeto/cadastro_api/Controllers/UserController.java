package com.meuprojeto.cadastro_api.Controllers;


import com.meuprojeto.cadastro_api.Services.UserService;
import com.meuprojeto.cadastro_api.Entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/cadastro")
    public User CriarUsuario(@Valid @RequestBody User user) {
       return userService.CriarCadastro(user);
    }

    @GetMapping("/listar")
    public List<User> listar() {
        return userService.listar();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> ExcluirCadastro(@PathVariable Long id){
        return userService.ExcluirCadastro(id);
    }
}
