# Projeto Biblioteca

Este é um projeto de gerenciamento de biblioteca desenvolvido com Spring Boot.

O objetivo do projeto é permitir o cadastro, listagem e exclusão de livros, além de associar uma playlist do Spotify a cada livro cadastrado.

## Funcionalidades

- Adicionar um novo livro
- Listar todos os livros cadastrados
- Deletar um livro

## Tecnologias Utilizadas

- Java 8
- Spring Boot 2.1
- Thymeleaf
- PostgreSQL
- Spring Data JPA

## Estrutura do Projeto

O projeto é organizado nas seguintes camadas:

- **Controller:** Contém os controladores responsáveis por lidar com as requisições HTTP.
- **Service:** Contém a lógica de negócio do aplicativo.
- **Model:** Contém as entidades que representam os dados do aplicativo.
- **Repository:** Contém as interfaces de repositório para acesso ao banco de dados.

## Endpoints

- **GET /bookfy:** Exibe a página principal da biblioteca.
- **GET /adicionar-livro:** Exibe o formulário para adicionar um novo livro.
- **POST /adicionar-livro:** Processa o formulário de adição de um novo livro.
- **GET /listar-livros:** Lista todos os livros cadastrados.
- **GET /deletar/{id}:** Deleta o livro selecionado.

## Como Executar o Projeto

### Pré-requisitos

- Java 8 ou superior
- Maven
- PostgreSQL

### Passos

1. Clone o repositório

2. Navegue até o diretório do projeto

3. Configure o banco de dados PostgreSQL no arquivo
  `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca
    spring.datasource.username=seu-usuario
    spring.datasource.password=sua-senha
    spring.jpa.hibernate.ddl-auto=update
    ```

5. Compile e execute o projeto usando Maven:
    ```bash
    mvn spring-boot:run
    ```

6. Acesse a aplicação no seu navegador:
    ```
    http://localhost:8090/bookfy
    ```
