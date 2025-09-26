package com.meuprojeto.cadastro_api.Services;

import com.meuprojeto.cadastro_api.Entities.User;
import com.meuprojeto.cadastro_api.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User CriarCadastro(User user) {
        return userRepository.save(user);
    }

    public List<User> listar() {
       return userRepository.findAll();
  }

    public void ExcluirCadastro(Long id) {
        userRepository.deleteById(id);
    }

    public void EditarCadastro(Long id, User user) {



        if (userRepository.existsById(id)) {
            User Existente= userRepository.findById(id).get();
            Existente.setNome(user.getNome());
            Existente.setEmail(user.getEmail());
            Existente.setSenha(user.getSenha());
            userRepository.save(Existente);
        }

    }





    }


