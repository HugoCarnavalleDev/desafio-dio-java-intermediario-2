# Banco Digital com Java e Orientação a Objetos

- Este projeto foi desenvolvido como parte do desafio da **[DIO.me](https://www.dio.me/)** com o objetivo de praticar os princípios da **Programação Orientada a Objetos (POO)** utilizando a linguagem **Java**. A proposta simula um sistema bancário simplificado, com operações reais de contas e clientes.

---

## Desafio Proposto

- Um banco oferece aos seus clientes dois tipos de contas — **Corrente** e **Poupança** — que disponibilizam as seguintes operações: **depósito**, **saque** e **transferência entre contas** da mesma instituição.

---

## Conceitos de POO Aplicados

- **`Abstração`**
Foca nos elementos essenciais do domínio bancário. Entidades como `Conta`, `Cliente` e `Banco` são modeladas por meio de classes que representam o comportamento esperado no mundo real.
- **`Encapsulamento`**
A implementação interna das classes é protegida, expondo apenas os métodos necessários para interação externa. Isso facilita a manutenção e evolução do código.
- **`Herança`**
As classes `ContaCorrente` e `ContaPoupanca` herdam atributos e métodos da classe abstrata `Conta`, promovendo reutilização de código e padronização de comportamentos.
- **`Polimorfismo`**
As contas são tratadas por meio de referências da superclasse `Conta`, permitindo o uso flexível de objetos específicos (corrente ou poupança) sem alterar a lógica principal.

---

## Estrutura do Projeto

- **`Banco.java`**  
  Representa uma instituição bancária com atributos como nome, número do banco e número da agência. Usada para associar contas a um banco e exibir suas informações.

- **`Cliente.java`**  
  Contém os dados pessoais do cliente, como nome completo, CPF, telefone, CEP e renda média. Essencial para vincular contas a seus respectivos titulares.

- **`IConta.java`**  
  Interface que define o **contrato** para todas as contas do sistema. Declara os métodos obrigatórios: `sacar`, `depositar`, `transferir` e `imprimirExtrato`.

- **`Conta.java`**  
  Classe abstrata que implementa a interface `IConta`. Define atributos comuns como saldo, cliente e banco, além de fornecer implementações padrão para operações bancárias.

- **`ContaCorrente.java`**  
  Especialização da classe `Conta`, incluindo a funcionalidade de **empréstimo pré-aprovado** com base na renda média do cliente. Também controla a contratação do empréstimo via entrada do console.

- **`ContaPoupanca.java`**  
  Especialização da classe `Conta`, com comportamento padrão para contas do tipo poupança, utilizando os métodos herdados da superclasse.

- **`Validador.java`**  
  Classe utilitária responsável por **validar a existência e o tipo da conta bancária** (corrente ou poupança) com base no número informado. Em caso de erro, redireciona o usuário ao menu de operações.

- **`Main.java`**  
  Classe principal que simula a aplicação no console. É responsável por criar objetos, iniciar operações bancárias e controlar o fluxo interativo com o usuário.

---

## Funcionalidades Implementadas

- **Criação de contas**  
  Permite a criação de contas correntes (nº entre 1000 e 4999) e contas poupança (nº entre 5000 e 9999), vinculadas a um cliente e a um banco.

- **Depósito em conta**  
  Adiciona valores ao saldo da conta com confirmação da operação.

- **Saque de valores**  
  Realiza saques com validação de saldo e mensagens de erro em caso de saldo insuficiente.

- **Transferência entre contas**  
  Efetua transferências entre contas da mesma instituição (corrente ↔ poupança), com validação do número da conta e saldo disponível.

- **Validação de contas**  
  Verifica se a conta existe e identifica seu tipo (corrente ou poupança). Redireciona ao menu de operações em caso de erro.

- **Impressão de extrato bancário**  
  Exibe extrato detalhado contendo data, informações da conta, cliente, banco e saldo disponível.

- **Solicitação e contratação de empréstimo (conta corrente)**  
  Oferece crédito pré-aprovado baseado na renda média do cliente. O cliente pode aceitar ou recusar o empréstimo diretamente via console.
