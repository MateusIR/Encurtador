# 🔗 Encurtador de Links com QR Code

Projeto completo de encurtador de URLs desenvolvido com **Spring Boot** . Além de encurtar URLs, o sistema gera automaticamente um **QR Code** correspondente à URL encurtada.

---

## 📦 Funcionalidades

- 🔗 Encurtar URLs automaticamente ou com customização.
- 📅 Armazenamento com data de criação.
- 🗑️ Remoção automática de links após 1 semana.
- 📲 Geração de QR Code (Base64) para facilitar compartilhamento.
- 🌐 Redirecionamento automático ao acessar a URL encurtada.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **JPA + Hibernate**
- **PostgreSQL**
- **ZXing (QR Code generation)**


---

## ⚙️ Como rodar localmente

### 🔧 Pré-requisitos

- Java 17+
- Maven 3.8+
- Git

### 📥 Clonando o projeto

```bash
git clone https://github.com/MateusIR/Encurtador
cd Encurtador
```
### 🛠️ Back-end
Navegue até o diretório raiz do projeto.

Crie e configure o arquivo **src/main/resources/application.properties** com as credenciais do seu banco de dados, ou crie um arquivo **.env**:

#### coloque as suas credenciais:
```
spring.datasource.url=${DATASOURCE_URL}
spring.datasource.username=${USERNAME}
spring.datasource.password=${PASSWORD}
```
#### Compile e rode a aplicação:
```bash

./mvnw spring-boot:run
```
A aplicação estará disponível em http://localhost:8080

### 📬 Rotas da API
#### Método	Rota	Descrição
POST:   /encurtador -------- Encurta uma URL \
GET: /r/{urlShort}  ---------- Redireciona para a URL original






### Exemplo de Payload (POST /encurtador)

```
{
  "url": "https://exemplo.com",
  "urlCustom": "meulink" // opcional
}
```
#### Exemplo de Resposta:
```
{
  "id": 1,
  "url": "https://exemplo.com",
  "url_short": "http://localhost:8080/r/abc123",
  "url_criadaEm": "2025-05-26T16:45:12",
  "qrCodeBase64": "iVBORw0KGgoAAAANSUhEUgAAABQAAA..."
}
```

O campo qrCodeBase64 pode ser exibido como imagem.

### 💻 Front-end
Navegue até o diretório onde está o **index.html**.

Abra o arquivo em um navegador moderno (Chrome, Edge, Firefox).

### 🧹 Tarefas Automáticas
Links são removidos automaticamente após 1 semana com uma tarefa agendada.