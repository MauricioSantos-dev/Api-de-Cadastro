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

    @GetMapping("/listar")
    public List<User> listar() {
        return userService.listar();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> ExcluirCadastro(@PathVariable Long id) {
        userService.ExcluirCadastro(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<User> editar(@PathVariable Long id, @Valid @RequestBody User user){
        userService.EditarCadastro(id, user);
        return ResponseEntity.ok().build();
    }
}
