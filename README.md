# Verificador de Transações - Sistema Anti-Golpe

Este projeto foi desenvolvido como parte da avaliação A3 da disciplina de Engenharia de Software. O sistema tem como objetivo prevenir golpes em transações financeiras analisando a confiabilidade de chaves Pix e documentos de vendedores.

## 💡 Funcionalidade

- **Cadastro de Vendedores**: Armazena dados de vendedores verificados por CPF ou CNPJ.
- **Registro de Transações**: Permite inserir transações e marca se são confiáveis.
- **Denúncias**: Recebe denúncias sobre chaves Pix suspeitas.
- **Score do Usuário**: Calcula e exibe a confiabilidade de uma chave Pix com base em transações e denúncias.

## ⚙️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3.2.0
- Maven
- PostgreSQL
- Postman (para testes)

## 📁 Estrutura do Projeto

```
com.a3.verificador
│
├── controller
│   ├── VendedorController.java
│   ├── TransacaoController.java
│   ├── DenunciaController.java
│   └── ScoreController.java
│
├── model
│   ├── Vendedor.java
│   ├── Usuario.java
│   ├── Transacao.java
│   └── Denuncia.java
│
├── repository
│   ├── VendedorRepository.java
│   ├── UsuarioRepository.java
│   ├── TransacaoRepository.java
│   └── DenunciaRepository.java
│
├── service
│   └── UsuarioService.java
│
└── VerificadorTransacoesApplication.java
```

## 🧪 Testes

Os endpoints REST foram testados via Postman utilizando as seguintes URLs:

- `POST /vendedor` – Cadastra vendedor
- `POST /transacao` – Registra uma transação
- `POST /denuncia` – Registra uma denúncia
- `GET /score/{chavePix}` – Retorna o score da chave Pix

## 🔌 Como Executar

1. **Clonar o repositório**
2. **Configurar o PostgreSQL** com banco `verificador`, usuário e senha no `application.properties`
3. **Executar com Maven**
   ```bash
   mvn spring-boot:run
   ```
4. A aplicação estará disponível em: `http://localhost:8080`

## 📄 Autor

Lucas Henrique Pacheco Baiocco e Ronald Medeiros Mauro
Curso: Análise e Desenvolvimento de Sistemas – Anhembi Morumbi  
Disciplina: Programação de Soluções Computacionais – A3 (2025)
