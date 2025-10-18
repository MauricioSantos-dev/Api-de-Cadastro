package com.meuprojeto.cadastro_api.Controllers;

import com.meuprojeto.cadastro_api.Entities.AuthenticationDTO;
import com.meuprojeto.cadastro_api.Entities.RegisterDTO;
import com.meuprojeto.cadastro_api.Entities.User;
import com.meuprojeto.cadastro_api.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data) {
        var senhaUsuario= new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var   auth = authenticationManager.authenticate(senhaUsuario);

        return ResponseEntity.ok().build();
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO data) {
        if(userRepository.findByEmail(data.email()) != null){
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        User newUser = new User(data.nome(),data.email(), encryptedPassword, data.role() );
        userRepository.save(newUser);
        return ResponseEntity.ok().build();

    }


}
