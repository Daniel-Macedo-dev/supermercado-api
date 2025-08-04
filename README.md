# Supermercado API

Uma API RESTful desenvolvida em Java utilizando Spring Boot para gerenciar produtos de um supermercado. Este projeto demonstra conceitos de Programação Orientada a Objetos (POO), como herança, polimorfismo, encapsulamento e o uso de DTOs para transferência de dados.

## Funcionalidades

- Cadastro de produtos com categorias específicas (ex: bebidas)
- Listagem e consulta por ID
- Atualização e exclusão de produtos
- Uso de herança para especialização de produtos
- Camada de serviço com interface e implementação (`ProdutoService`, `ProdutoServiceImpl`)
- Persistência com banco de dados em memória (H2)
- Testes via Postman

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Banco de dados H2
- Postman (para testes)
- Lombok
- Maven

## Organização do Projeto

```
supermercado-api/
├── business/                # Camada de serviço
│   ├── ProdutoService.java
│   └── ProdutoServiceImpl.java
├── infrastructure/
│   ├── entities/            # Entidades JPA
│   │   ├── Produto.java
│   │   └── ProdutoBebida.java
│   └── repository/          # Interfaces JPA
│       └── ProdutoRepository.java
├── dto/                     # Data Transfer Objects
│   └── ProdutoDTO.java
├── controller/              # Camada de controle (REST)
│   └── ProdutoController.java
└── application/
    └── SupermercadoApiApplication.java
```

## Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/Daniel-Macedo-dev/supermercado-api.git
cd supermercado-api
```

2. Compile e execute o projeto com Maven (ou abra com sua IDE):

```bash
./mvnw spring-boot:run
```

3. Acesse o H2 Console (opcional):

```
http://localhost:8080/h2-console
```

- JDBC URL: `jdbc:h2:mem:testdb`
- Usuário: `sa`
- Senha: (deixe em branco)

4. Teste os endpoints via Postman (ex: `GET`, `POST`, `PUT`, `DELETE` em `http://localhost:8080/produtos`).

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests para melhorias, correções de bugs ou novas funcionalidades.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
