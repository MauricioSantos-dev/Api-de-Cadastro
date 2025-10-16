package com.meuprojeto.cadastro_api.Entities;

    public enum UserRole {
        ADMIN("admin"),
        USER("user");

        private String role;

        UserRole(String role){
            this.role = role;
        }

        public String getRole() {
            return role;
        }
    }

