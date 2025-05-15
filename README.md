📦 Checkpoint API
Uma API REST desenvolvida em Java com Spring Boot para gerenciamento de filiais e motos. Esse sistema permite o cadastro, atualização, exclusão e listagem dessas entidades, sendo ideal para sistemas logísticos ou de transporte.

📌 Funcionalidades
CRUD de Motos

CRUD de Filiais

Enum de StatusMoto (ex: disponível, em manutenção, etc.)

Tratamento global de exceções

Arquitetura em camadas (Controller, Service, Repository, Model)

🚀 Tecnologias
Java 17+

Spring Boot

Spring Data JPA

Maven

H2 Database (ou configure outro via application.properties)

JUnit para testes

⚙️ Como rodar localmente
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/seu-usuario/checkpoint.git
cd checkpoint
Compile e rode o projeto:

bash
Copiar
Editar
./mvnw spring-boot:run
Acesse a API:

O backend estará disponível em:

arduino
Copiar
Editar
http://localhost:8080
🔎 Endpoints principais
Recurso	Método	Endpoint
Motos	GET	/motos
Motos	POST	/motos
Motos	PUT	/motos/{id}
Motos	DELETE	/motos/{id}
Filiais	GET	/filiais
Filiais	POST	/filiais
Filiais	PUT	/filiais/{id}
Filiais	DELETE	/filiais/{id}

📁 Estrutura de diretórios
plaintext
Copiar
Editar
checkpoint/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.mottujavaadv.checkpoint/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── model/
│   │   │       └── repository/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
