package com.meuprojeto.cadastro_api.Controllers;


import com.meuprojeto.cadastro_api.Services.UserService;
import com.meuprojeto.cadastro_api.Entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/cadastro")
    public User CriarUsuario(@Valid @RequestBody User user) {
       return userService.CriarCadastro(user);
    }



}
