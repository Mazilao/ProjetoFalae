# API Spring Boot - [Nome do Projeto]

## Descrição
Este projeto é uma API desenvolvida em Spring Boot.

---

## Requisitos
Para rodar o projeto localmente, você precisará das seguintes ferramentas instaladas:
- **Java**: Versão 17
- **Banco de Dados**: H2
localhost:8080/h2-console
User = sa
Password = 123
(application.properties) para vizualizar mais informacoes do banco

---

## Rotas
Users:
  POST: localhost:8080/api/auth/register
  GET: localhost:8080/api/auth/users

Products: 
  POST: localhost:8080/api/products
  GET: localhost:8080/api/products/{id}
  PUT: localhost:8080/api/products/{id}
  DEL: localhost:8080/api/products/{id}

OrderItem:
  POST: localhost:8080/api/orders
  GET: localhost:8080/api/orders/{id}

## JSON

Users:
  POST:
  {
    "name": "Gabriel",
    "email": "gabriel@gabriel",
    "address": "Rua Espirito Santo",
    "phone": "32998331571"
}
Products:
  POST:
{
    "name": "Coxinha",
    "price": 5.0,
    "category": "Salgado",
    "description": "Salgado De frango"
}
  PUT:
{
    "name": "Coxinha",
    "price": 10.0,
    "category": "Salgado",
    "description": "Salgado De frango"
}
OrderItem:
  POST:
{
  "userId": 1,
  "items": [
    { "productId": 1, "quantity": 2 },
    { "productId": 3, "quantity": 1 }
  ]
}

