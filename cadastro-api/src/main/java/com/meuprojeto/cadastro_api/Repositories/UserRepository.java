package com.meuprojeto.cadastro_api.Repositories;

import com.meuprojeto.cadastro_api.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
