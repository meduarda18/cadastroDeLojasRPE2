# Cadastro de Lojas Físicas e Virtuais RPE

API desenvolvida para facilitar o gerenciamento e manutenção de cadastros de lojas físicas e virtuais dos clientes da RPE.

## Linguagem 

* Java17

## Banco de Dados

* MySQL

* H2 Database (Para os testes automatizados)

## Tecnologias 

* Maven;

* Spring Boot;

* Spring DATA JPA;

* Spring Web;

* Springdoc OpenAPI(Swagger);

* Spring Boot Validation;

## Práticas adotadas

* SOLID;

* API Rest;

* Padrão Repository;

* Testes automatizados;

* Validações de entrada;

* Injeção de Dependências;

* Consultas com o Spring DATA JPA;

* Geração automática do Swagger com a OpenAI.

## Como executar

Para executar este projeto em seu ambiente local, siga as seguintes etapas:

### Requisitos de Software:

* Java 17 JDK instalado em sua máquina;
* Maven para gerenciar as dependências.

### Clonar repositório:

* https://github.com/meduarda18/cadastroDeLojasRPE2.git

### Banco de dados

* Certifique-se de que você tenha um servidor MySQL em execução em sua máquina local ou acesse um servidor remoto;

* Configure as propriedades de conexão com o banco de dados, como URL, usuário e senha;

* Crie um banco de dados MySQL chamado cadastro_lojas_rpe.

### Execução do projeto

* Navegue pelo seguinte caminho dentro do projeto:

  **src.main.java.br.com.rpe.lojas.cadastro**
 
  e acesse a pasta **CadastrolojasrpeApplication.java** 
 
  para executar o projeto.

### Acesso a API

* http://localhost:8080/lojas

* http://localhost:8080/lojas/fisicas

* http://localhost:8080/lojas/virtuais

### Acesso a documentação da API(Swagger)

* http://localhost:8080/swagger-ui.html

### Execução dos testes

* Navegue pelo seguinte caminho dentro do projeto:

  **src.test.java.br.com.rpe.lojas.cadastro**

  e acesse a pasta **CadastrolojasrpeApplicationTests.java**
  
  para executar os testes básicos.