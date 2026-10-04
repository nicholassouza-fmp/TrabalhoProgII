# 🎓 Projeto Escola EAD

Sistema desenvolvido em **Java** para gerenciamento de alunos, cursos, notas e mensalidades de uma escola de ensino a distância.

O projeto foi desenvolvido para a disciplina de **Linguagem de Programação II**, com foco nos principais conceitos de **Programação Orientada a Objetos (POO)**.

## 📌 Sobre o Projeto

O sistema permite cadastrar e gerenciar alunos, associá-los a cursos, lançar notas, calcular médias e controlar mensalidades.

O projeto também possui suporte a **alunos bolsistas**, utilizando herança e sobrescrita de métodos.

## ⚙️ Funcionalidades

* Cadastro de alunos;
* Cadastro de alunos bolsistas;
* Cadastro de cursos;
* Associação de alunos aos cursos;
* Visualização dos alunos cadastrados;
* Lançamento de 3 notas por aluno;
* Cálculo da média;
* Cadastro de mensalidades;
* Consulta financeira;
* Registro do pagamento de mensalidades;
* Visualização dos cursos e seus alunos.

## 🧩 Estrutura do Projeto

### `Aluno`

Representa os alunos do sistema, armazenando seus dados pessoais, curso, notas e mensalidades.

### `AlunoBolsista`

Herda as características de `Aluno` e adiciona o tipo de bolsa. Também sobrescreve o método de exibição dos dados.

### `Curso`

Representa os cursos disponíveis, armazenando código, nome e duração.

### `ListaDeAlunos`

Responsável por armazenar e gerenciar os alunos utilizando um vetor de objetos `Aluno`.

### `Mensalidade`

Representa as parcelas financeiras dos alunos, armazenando o valor e o status de pagamento.

### `SistemaEscolaEAD`

Classe principal do sistema. Contém o menu e controla as operações realizadas pelo usuário.

## 🧠 Conceitos de POO Utilizados

O projeto utiliza:

* **Encapsulamento** — atributos privados com getters e setters;
* **Herança** — `AlunoBolsista` herda de `Aluno`;
* **Polimorfismo** — sobrescrita do método `exibeDados()`;
* **Construtores** — utilizados para inicializar os objetos;
* **Validação de dados** — verificações de notas, códigos e informações cadastradas.

## 📚 Estruturas Utilizadas

O projeto utiliza diferentes estruturas de dados:

* `Aluno[]` para armazenar alunos;
* `double[]` para armazenar as notas;
* `Mensalidade[]` para armazenar as parcelas;
* `Curso[][]` para armazenar os cursos;
* Estruturas de repetição e seleção para controlar o sistema.

## 💻 Tecnologias

* **Java**
* **BlueJ**

## 🎯 Objetivo

O objetivo do projeto é aplicar, de forma prática, os conceitos de **Programação Orientada a Objetos**, trabalhando com classes, objetos, encapsulamento, herança, polimorfismo, vetores e matrizes.

## 👨‍💻 Projeto Acadêmico

Projeto desenvolvido para fins acadêmicos na graduação de **Análise e Desenvolvimento de Sistemas (ADS)**.
