# 🛒 Supermercado API 🛒

Uma API RESTful desenvolvida em Java utilizando Spring Boot para gerenciar produtos de um supermercado. Este projeto demonstra conceitos de Programação Orientada a Objetos (POO), como herança, polimorfismo, encapsulamento e o uso de DTOs para transferência de dados.

---

## 🚀 Funcionalidades

- Cadastro de produtos com categorias específicas (ex: bebidas)  
- Listagem e consulta por ID  
- Atualização e exclusão de produtos  
- Uso de herança para especialização de produtos  
- Camada de serviço com interface e implementação (`ProdutoService`, `ProdutoServiceImpl`)  
- Persistência com banco de dados H2 (em memória)  
- Testes via Postman  

---

## ⚙️ Tecnologias Utilizadas

- Java 21  
- Spring Boot  
- Spring Data JPA  
- Banco de dados H2 (desenvolvimento)  
- Banco de dados MySQL (produção/local via Docker)  
- Docker & Docker Compose  
- Lombok  
- Maven  
- Postman  

---

## ▶️ Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/Daniel-Macedo-dev/supermercado-api.git
cd supermercado-api
```

2. Compile e execute o projeto com Maven (H2 - em memória):
```bash
./mvnw spring-boot:run
```
3. Acesse o H2 Console (opcional):
```bash
http://localhost:8080/h2-console
```
- JDBC URL: jdbc:h2:mem:testdb
- Usuário: sa
- Senha: (deixe em branco)

4. Teste os endpoints via Postman:
```bash
GET, POST, PUT, DELETE em http://localhost:8080/produtos
```
5. Rodando com MySQL via Docker (opcional):
```bash
docker-compose build
docker-compose up -d
```
- Isso cria dois containers:

      - supermercado-mysql → MySQL rodando com banco supermercado_api e usuário dedicado

      - supermercado-api → API Spring Boot conectada ao MySQL

- A API estará disponível em: http://localhost:8080

- O MySQL estará acessível para ferramentas externas no host localhost, porta 3306

- Nota: Com essa opção, não é necessário configurar manualmente banco ou properties. O Docker cuida de inicializar tudo automaticamente.

## 🤝 Contribuições

Contribuições são bem-vindas! Abra issues ou pull requests para melhorias, correções de bugs ou novas funcionalidades.

## 📄 Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
