# HospedaAe - Sistema de Gestão de Hospedagem (Fase Inicial)

## 🏡 Descrição do Projeto

O **HospedaAe** é um sistema de gerenciamento de **pousadas e hotéis**, criado como um projeto de estudo. O foco é simplificar o controle de rotinas essenciais como **gestão de reservas**, **informações de hóspedes** e **acomodação de quartos**. O projeto foi desenvolvido para aplicar conceitos de programação orientada a objetos e arquitetura de software, utilizando o ecossistema Java e a arquitetura **MVC (Model-View-Controller)**.

## ✨ Funcionalidades

* **Gestão de Quartos**: Adicione, edite ou remova quartos, com informações sobre tipo, capacidade e status (disponível, ocupado, em manutenção).
* **Gestão de Hóspedes**: Cadastre informações de hóspedes de forma simples e segura.
* **Sistema de Reservas**: Realize o agendamento de reservas e mantenha o controle do histórico.
* **Check-in & Check-out**: Atualize o status dos hóspedes para refletir a ocupação atual dos quartos.

## 🚀 Tecnologias Utilizadas

* **Linguagem**: Java 21
* **Framework**: Spring Boot
* **Arquitetura**: MVC (Model-View-Controller)
* **Banco de Dados**: H2 (em memória)
* **Anotações**: Lombok
* **Persistência**: Spring Data JPA
* **Build**: Maven

## ⚙️ Como Rodar o Projeto Localmente

Siga os passos abaixo para ter uma cópia do projeto em execução na sua máquina.

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

* **JDK 21** ou superior
* **Maven**
* Uma IDE como IntelliJ IDEA, Eclipse ou VS Code com as extensões Java

### Passos para a instalação

1.  Clone este repositório:
    ```bash
    git clone [https://github.com/DevRickLee/HospedaAe.git](https://github.com/DevRickLee/HospedaAe.git)
    ```
2.  Navegue até o diretório do projeto:
    ```bash
    cd HospedaAe
    ```
3.  Execute o projeto usando o Maven:
    ```bash
    ./mvnw spring-boot:run
    ```
    *(No Windows, use `mvnw spring-boot:run`)*

O projeto estará rodando em `http://localhost:8080`. Você pode acessar os endpoints da API para interagir com o sistema.

## 🤝 Como Contribuir

Contribuições, sugestões e relatórios de bugs são muito bem-vindos! Se você encontrar um bug ou tiver uma ideia de melhoria, sinta-se à vontade para abrir uma **issue** ou um **pull request**.

---
**Link do Repositório:** https://github.com/DevRickLee/HospedaAe.git