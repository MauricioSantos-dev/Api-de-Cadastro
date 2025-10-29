Esse projeto é uma API REST desenvolvida em Spring Boot com autenticação e autorização utilizando Spring Security e JWT (JSON Web Token).
O sistema permite o cadastro, login e autenticação segura de usuários, garantindo que apenas usuários autenticados possam acessar rotas protegidas. 


Tecnologias Utilizadas:

-Java 21

-Spring Boot 3

-Spring Security

-JWT (JSON Web Token)

-Spring Data JPA

-Hibernate

-Maven

-Banco de Dados: H2


Conceitos Implementados:

-Spring Security Configurado Manualmente: usando SecurityFilterChain

-Filtro personalizado (SecurityFilter) que valida o token em todas as requisições

-Autenticação Stateless: sem armazenamento de sessão

-JWT seguro: gerado e validado pelo TokenService

-Criptografia de senha: via BCryptPasswordEncoder

-UserDetailsService customizado: (AuthorizationService) busca usuários no banco

-DTOs: para separar a camada de domínio da camada de transporte


