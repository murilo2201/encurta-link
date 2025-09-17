# 📊 Encurtador de Links - Java + Spring Boot + Frontend 🚀

Bem-vindo ao projeto de encurtador de links com arquitetura REST API, documentação Swagger e integração com MySQL! Uma aplicação completa para criação e redirecionamento de links curtos. 🧠💻

---

## ✨ Sobre o Projeto
Este sistema oferece uma API RESTful completa para encurtamento de URLs, com documentação interativa via Swagger e banco de dados MySQL para persistência dos dados.
Além do backend, conta com um frontend simples feito com HTML, JavaScript e CSS, utilizando Tailwind CSS para estilização! 🎯

---

## 💡 Funcionalidades
- 🔗 **Criar links curtos a partir de URLs originais**
- 📚 **Documentação da API com Swagger/OpenAPI**
- 🗄️ **Integração com MySQL para persistência de dados**
- 🔧 **Configuração simplificada para fácil execução**
- 🚀 **RESTful com endpoints bem definidos**
- 🌐 **Testes via Swagger ou API Client**
- 💻 **Frontend simples com HTML, CSS(Tailwind) e JavaScript**

---

## ⚙️ Tecnologias e Ferramenta 

### Backend

- ☕ **Java 21**
- **Spring Boot 3.x (Web, JPA)**
- 🌐 **Spring Web**
- 🗂️ **Spring Data JPA**
- 🐬 **MySQL Database (banco principal)**
- 🧪 **H2 Database (apenas para testes locais)**
- 🧾 **Maven / pom.xml**

### Frontend

- 🖥️ **HTML**
- 🎨 **CSS**
- ⚡ **JavaScript**
- 💨 **Tailwind CSS**

#### 💡Observação: o projeto roda apenas localmente, sem deploy online.

---

## 🏃 Como Rodar o Projeto
### Pré-requisitos:

- ☕ **Java 21 ou superior**
- 🐬 **MySQL instalado e rodando**
- 📦 **Maven instalado**
- 🌐 **Git para clonar o repositório**

No arquivo `application.properties`, configure assim:

```properties
spring.application.name=encurta-link

 MySQL Database

spring.datasource.url=jdbc:mysql://localhost:3306/NOME_DO_BANCO?createDatabaseIfNotExist=true
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

 JPA

spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

 Desliga H2

spring.h2.console.enabled=false
```


#### ➡️ Substitua NOME_DO_BANCO, SEU_USUARIO e SUA_SENHA pelas suas credenciais locais.

--- 

## ⚙️ Configuração de CORS


```java
package com.murilo.encurta_link.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("*");
    }
}
```

#### ⚠️ Caso use outra porta no frontend, altere o allowedOrigins.


📊 Endpoints da API
-------------------------

| Método | Endpoint      | Descrição                               |
|--------|----------------|------------------------------------------|
| GET    | /{code}         | Redireciona para a URL original           |
| POST   | /encurtar       | Cria um novo link curto                    |
| GET    | /urls            | Lista todas as URLs já criadas             |

#### 📝 Obs: No momento o frontend usa apenas o endpoint POST `/encurtar`, os outros serão adicionados com o tempo pois ainda não estão implementados no frontend.


## ⚠️ Notas Importantes

- ✅ O banco será criado automaticamente (createDatabaseIfNotExist=true)
- ✅ SSL desabilitado para desenvolvimento (useSSL=false)
- ✅ Conexão segura habilitada (allowPublicKeyRetrieval=true)
- ✅ H2 Database desabilitado para uso exclusivo do MySQL
- ✅ As tabelas são criadas automaticamente pelo Hibernate (ddl-auto=update)

---

🚀 Para Recrutadores/Testadores



1. **Clone o projeto**
2. **Configure suas credenciais MySQL no `application.properties`**
3. **Execute `mvn spring-boot:run`**
4. **Acesse `http://localhost:8080/swagger-ui.html`**
5. **Teste os endpoints diretamente pela interface Swagger ou pelo Postman**
6. **Abra o frontend (`index.html`) no seu navegador e teste a criação de links curtos pelo formulário**


---

## 👨‍💻 Autor
**Murilo França de Sousa**  
- GitHub: [murilo2201](https://github.com/murilo2201)

- Email: murilofs.franca@gmail.com

