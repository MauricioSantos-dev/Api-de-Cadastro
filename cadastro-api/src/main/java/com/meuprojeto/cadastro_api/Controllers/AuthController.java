package com.meuprojeto.cadastro_api.Controllers;

import com.meuprojeto.cadastro_api.Entities.AuthenticationDTO;
import com.meuprojeto.cadastro_api.Entities.LoginResponseDTO;
import com.meuprojeto.cadastro_api.Entities.RegisterDTO;
import com.meuprojeto.cadastro_api.Entities.User;
import com.meuprojeto.cadastro_api.Repositories.UserRepository;
import com.meuprojeto.cadastro_api.infra.security.TokenService;
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
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data) {
        var senhaUsuario= new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var   auth = authenticationManager.authenticate(senhaUsuario);

        var token= tokenService.generateToken((User)auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
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
