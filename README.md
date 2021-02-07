# TON-Funcionário

<h5>Projeto backend desenvolvido em <i>Java</i>, utilizando framework <i>Spring Boot</i>, para teste técnico.</h5>


## Sobre

Aplicação REST com objetivo de permitir ao usuário consumir endpoints para controle de funcionários cadastrados. Acessando os controllers é possível realizar operações no banco de dados para criação, alteração, exclusão e listagem das entidades cadastradas. Documentação disponível no <a href='http://15.228.41.2:8084/swagger-ui.html#'/>Swagger</a>. Consiste em sete endpoints, sendo obrigatória a [autenticação](#autenticação) via token em alguns.

## Diretórios
#### Aplicação

    .
    └── main
         ├── app             # Classes utilizadas no projeto
         └── config          # Configurações utilizadas no projeto

O objetivo da divisão é separar os arquivos por responsabilidades. Tanto na camada do app quanto na do config os pacotes estão seguindo um padrão. 
Para a camada <b>app</b> existe a divisão por controller, models e validators. O pacote controller possui apenas arquivos referentes aos controllers e seus retornos, o pacote models apenas arquivos referentes as entidades e repositórios, e na pasta validators funções para validações de regra de negócio.
Para a camada <b>config</b> existe a divisão por handler, security e swagger. O pacote handler engloba os tratamentos de exceção, o pacote security as configurações de segurança e o pacote swagger as configurações para documentação.

#### Testes

    .
    └── main
         ├── controllers     # Testes para os controllers
         └── models          # Testes para as entidades

O objetivo da divisão é separar os arquivos por camada. Considerando que a aplicação possui a camada das entidades e a camada dos controllers.


## Controller
#### Funcionario
Responsável por todos os métodos referentes a entidade Funcionário. Todos os endpoints necessitam de [autenticação](#autenticação).
#### User
Responsável pelos métodos de criação e autenticação de usuário.

## Models
#### Entity
Classes para mapear o banco de dados e construir objetos baseado no retorno da consulta.
#### Repository
Interfaces para transitar informações entre o banco de dados e a aplicação

## Validators
#### Regra de negócio
Classes que carregam regras de negócios da aplicação.

## Handler
#### Exceção
Tratar retorno quando há algum problema na validação do body enviado para criação e alteração de funcionário.
## Segurança
#### Autenticação
Autenticação feita com Spring Secutiry e JWT. Para os endpoints que necessitam de autenticação é necessário ter um usuário válido para geração de token.
#### Autorização
Endpoints de criação de usuário e autenticação estão disponíveis para todos, juntamente com os endpoints para acessar arquivos de documentação.

## Swagger
#### Documentação
<a href='http://15.228.41.2:8084/swagger-ui.html#'/>Documentação</a> para os endpoints disponíveis na aplicação com exemplos de request e response.

## Testes
#### Controller
Testes mockados para validar retorno dos endpoints existentes.
#### Models
Testes para validar métodos das classes utilizadas para comunicação com banco de dados.

## Como rodar

Necessário ter instalado <a href="https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html">Java 11</a>, <a href="https://maven.apache.org/download.cgi">Maven</a> e <a href="https://docs.docker.com/">Docker</a>.

1. Clone o repositório.
2. Alterar configurações do banco dados que se encontram no application.properties.
3. Acessar o diretório do projeto e executar o seguinte comando <i>mvn spring-boot:build-image</i>.
4. Executar comando para iniciar imagem <i>docker run --tty --publish 8080:8080 {{nome do arquivo gerado}}</i>.
5. Alterar o hostname nas variáveis de ambiente da collection e acessar endpoints.