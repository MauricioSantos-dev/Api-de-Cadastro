package com.meuprojeto.cadastro_api.Services;

import com.meuprojeto.cadastro_api.Entities.User;
import com.meuprojeto.cadastro_api.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User CriarCadastro(User user) {
        return userRepository.save(user);
    }

}
