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

3. Rode o projeto:
    mvn spring-boot:run

A aplicação estará disponível em http://localhost:8080.

## Endpoints da API

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

## Importando a Collection do Postman

Para facilitar o uso e testar a API, incluí uma collection do **Postman** no projeto. Siga os passos abaixo para importar a collection no Postman:

### Passos para importar a collection:

1. **Baixe o arquivo da Collection**:
   - Após clonar o repositório, acesse a pasta `postman` no projeto.
   - O arquivo da collection será chamado `Orders project.postman_collection.json`.

2. **Importe a collection no Postman**:
   - Abra o **Postman**.
   - No canto superior esquerdo, clique em **Import**.
   - Selecione **File** e escolha o arquivo `Orders project.postman_collection.json` que você baixou do repositório.
   - Clique em **Open** para adicionar a collection à sua interface do Postman.

3. **Testar os Endpoints**:
   - Agora você pode usar a collection no Postman para testar os endpoints da API, como descrito na seção "Endpoints da API".

Observações
Certifique-se de que o banco de dados PostgreSQL esteja em funcionamento antes de iniciar o projeto.
