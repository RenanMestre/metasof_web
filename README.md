# 🌐 MetaSoft Web

Sistema web para administração de empresas parceiras, funcionários e serviços, desenvolvido com **Spring Boot**, **Thymeleaf** e **MySQL**.

![GitHub last commit](https://img.shields.io/github/last-commit/SeuUsuario/metasof_web?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/SeuUsuario/metasof_web?style=for-the-badge)
![GitHub repo size](https://img.shields.io/github/repo-size/SeuUsuario/metasof_web?style=for-the-badge)

---

## 📸 Preview

![Preview da Tela de Administração](caminho/para/screenshot.png)

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
  - Spring Security
- **Thymeleaf**
- **MySQL**
- **Bootstrap 5**
- **Maven**

---

## 📂 Estrutura do Projeto

📦 src/main/java
├── com.api.metasoft
│ ├── MetaSoftApplication.java
│ ├── controller
│ │ ├── MetaSoftController.java
│ │ └── OutrosControllers...
│ ├── repository
│ │ └── ...Repository.java
│ ├── service
│ │ └── ...Service.java
│ └── config
│ └── SecurityConfig.java
├── com.metasoft.thymeleaf
│ └── Entidades para o Thymeleaf

---

## 📌 Funcionalidades

- ✅ Cadastro e listagem de empresas parceiras
- ✅ Cadastro e listagem de funcionários
- ✅ Cadastro e listagem de serviços (pedidos)
- ✅ Exclusão de registros com confirmação
- ✅ Autenticação com Spring Security
- ✅ Interface moderna com Bootstrap
- ✅ Estrutura MVC separada (Controller / Service / Repository)
