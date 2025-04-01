# Spring Boot Order Service

Este é um projeto simples utilizando **Spring Boot** para gerenciar pedidos em um sistema de e-commerce. A aplicação expõe uma API REST para criar, listar e excluir pedidos.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para construção de aplicações Java.
- **PostgreSQL**: Banco de dados relacional para armazenar os pedidos.
- **JPA/Hibernate**: Para interação com o banco de dados de forma orientada a objetos.
- **Maven**: Gerenciador de dependências e build tool.

## Como Rodar o Projeto

### Pré-requisitos

1. **Java 17** ou superior instalado.
2. **Maven** instalado para construir o projeto.
3. **PostgreSQL** configurado.

### Passos

1. Clone o repositório:
   ```bash
   [git clone https://github.com/seu-usuario/order-service.git](https://github.com/DiCarvalho1/order-service.git)

2. Navegue até a pasta do projeto:
    cd order-service

3. Configure as credenciais do banco de dados no arquivo application.properties:
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password

4. Rode o projeto:
    mvn spring-boot:run

A aplicação estará disponível em http://localhost:8080.

Endpoints da API

1. Criar um Pedido
Método: POST

Endpoint: /orders

Request body:
    {
    "customerName": "João Silva",
    "totalAmount": 150.75
    }

Resposta: 201 Created

2. Listar Pedidos
Método: GET

Endpoint: /orders

Resposta:
    [
    {
        "id": 1,
        "customerName": "João Silva",
        "totalAmount": 150.75,
        "createdAt": "2025-03-31T14:30:00"
    }
    ]

3. Buscar Pedido por ID
Método: GET

Endpoint: /orders/{id}

Resposta: Pedido encontrado ou 404 Not Found se não existir.

4. Excluir Pedido
Método: DELETE

Endpoint: /orders/{id}

Resposta: 204 No Content após excluir com sucesso.

Observações
Certifique-se de que o banco de dados PostgreSQL esteja em funcionamento antes de iniciar o projeto.
