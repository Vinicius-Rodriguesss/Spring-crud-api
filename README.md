# 🚀 CRUD API - Spring Boot

API REST desenvolvida com Spring Boot para gerenciamento de tarefas utilizando arquitetura monolítica.

## 🛠️ Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Docker
* Maven

---

# 🧱 Arquitetura do projeto

O projeto segue uma arquitetura monolítica organizada em camadas, separando responsabilidades para facilitar manutenção e escalabilidade.

## 📁 Estrutura das pastas

```bash id="d2m8q1"
src/main/java/com/viniciusdev/crud
│
├── controller
├── dto
├── exceptions
├── handlers
├── model
├── repository
├── service
└── CrudApplication
```

### 📌 Responsabilidade de cada camada

| Pasta        | Responsabilidade                                         |
| ------------ | -------------------------------------------------------- |
| `controller` | Recebe as requisições HTTP e retorna as respostas da API |
| `dto`        | Objetos utilizados para entrada e saída de dados         |
| `exceptions` | Exceptions customizadas da aplicação                     |
| `handlers`   | Tratamento global de exceptions                          |
| `model`      | Entidades da aplicação                                   |
| `repository` | Comunicação com o banco de dados                         |
| `service`    | Regras de negócio da aplicação                           |

---

# 🔐 Configuração das variáveis de ambiente

Crie um arquivo `.env` na raiz do projeto:

```env id="m7c4v9"
USER_POSTGRES=admin
PASSWORD_POSTGRES=admin123
DB_POSTGRES=crud_db

DB_HOST=localhost
DB_PORT=5432
```

---

# 🐳 Docker Compose

## docker-compose.yml

```yml id="r4x8t6"
services:
   db:
      image: postgres:17
      container_name: local
      restart: always
      environment:
         POSTGRES_USER: ${USER_POSTGRES}
         POSTGRES_PASSWORD: ${PASSWORD_POSTGRES}
         POSTGRES_DB: ${DB_POSTGRES}
      ports:
         - "5432:5432"
      volumes:
         - postgres_data:/var/lib/postgresql/data

volumes:
   postgres_data:
```

---

# ⚙️ Configuração do application.properties

```properties id="v9n3y5"
spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_POSTGRES}
spring.datasource.username=${USER_POSTGRES}
spring.datasource.password=${PASSWORD_POSTGRES}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

# ▶️ Executando o projeto

## Subir o banco de dados

```bash id="t6k2p8"
docker compose up -d
```

---

## Executar a aplicação

```bash id="f1q7m4"
./mvnw spring-boot:run
```

Ou execute diretamente pela IDE.

---

# 📌 Endpoints da API

## Criar tarefa

```http id="w3r8n2"
POST /v1/tasks
```

### Body

```json id="u5x1c9"
{
  "title": "Estudar Spring Boot",
  "description": "Aprender CRUD com Java"
}
```

---

## Listar todas as tarefas

```http id="l2v7k5"
GET /v1/tasks
```

---

## Buscar tarefa por ID

```http id="b4n9y1"
GET /v1/tasks/{id}
```

---

## Atualizar tarefa

```http id="h6p3q8"
PUT /v1/tasks/{id}
```

### Body

```json id="g8t2m6"
{
  "title": "Atualizar tarefa",
  "description": "Nova descrição"
}
```

---

## Deletar tarefa

```http id="e7w1z4"
DELETE /v1/tasks/{id}
```

---

# ✅ Funcionalidades

* Criar tarefas
* Buscar tarefas por ID
* Listar tarefas
* Atualizar tarefas
* Deletar tarefas
* Tratamento global de exceptions
* Integração com PostgreSQL
* Uso de Docker
* Variáveis de ambiente
* Respostas HTTP com ResponseEntity

---

# 📚 Conceitos aplicados

* API REST
* Arquitetura monolítica
* Arquitetura em camadas
* DTOs
* Injeção de dependência
* JPA/Hibernate
* Tratamento de exceptions
* Persistência de dados
* Dockerização da aplicação

---

# 👨‍💻 Desenvolvido por

Vinicius Rodrigues
