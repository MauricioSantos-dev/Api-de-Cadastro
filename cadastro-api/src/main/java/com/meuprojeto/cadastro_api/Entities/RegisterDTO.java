package com.meuprojeto.cadastro_api.Entities;

public record RegisterDTO(String email, String senha, String nome, UserRole role) {
}
