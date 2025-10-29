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

    public List<User> listar() {
       return userRepository.findAll();
  }



    }








