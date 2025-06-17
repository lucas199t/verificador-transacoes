# Verificador de Transações por PIX

Sistema desenvolvido como projeto da disciplina de Engenharia de Software com o objetivo de simular uma aplicação de prevenção a fraudes em transações por PIX, como golpes de compras inexistentes.

---

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3.2**
- **PostgreSQL** (via Docker)
- **Maven**
- **Docker + Docker Compose**

---

## ⚖️ Funcionalidades
- Cadastro e listagem de **transações**
- Registro de **denúncias** contra vendedores suspeitos
- Geração de **score de confiabilidade** de vendedores
- API REST com endpoints para usuários, vendedores, transações e denúncias

---

## 🔧 Como Executar o Projeto

### 1. Clonar o repositório
```bash
git clone https://github.com/lucas199t/verificador-transacoes.git
cd verificador-transacoes
```

### 2. Build com Maven
```bash
mvn clean package
```

### 3. Executar com Docker Compose
```bash
docker-compose up --build
```

A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080)

---

## 📢 Endpoints principais
- `POST /transacao`
- `POST /denuncia`
- `GET /vendedores` com score

---

## 💼 Objetivo do Projeto
Demonstrar, de forma prática, um sistema capaz de receber dados de transações, denúncias e gerar um indicador que ajude o usuário a identificar possíveis golpes por PIX.

---

## ✅ Contribuição
Pull Requests são bem-vindos! Para grandes mudanças, abra uma issue primeiro para discutir o que você gostaria de modificar.

---

## ✉️ Contato
Desenvolvido por **Lucas Henrique Pacheco Baiocco, Ronald Medeiros Mauro, Hugo Luiz Silva Carneiro**  
[LinkedIn](https://www.linkedin.com/in/lucas-baiocco/)
[LinkedIn](https://www.linkedin.com/in/ronald-medeiros-7136411bb/)
Contatos: 
lucashenriquepacheco2905@gmail.com
ronald.medeiros.mauro2005@gmail.com
hugo_scarneiro@outlook.com
