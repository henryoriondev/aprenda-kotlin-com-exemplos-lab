# Aprenda Kotlin Com Exemplos: Desafio de Projeto (Lab)

Desafio de Projeto criado para avaliação do conteúdo técnico explorado no repositório [aprenda-kotlin-com-exemplos](https://github.com/digitalinnovationone/aprenda-kotlin-com-exemplos). **Nesse contexto, iremos abstrair o seguinte domínio de aplicação:**

**A [DIO](https://web.dio.me) possui `Formacoes` incríveis que têm como objetivo oferecer um conjunto de `ConteudosEducacionais` voltados para uma stack tecnológica específica, preparando profissionais de TI para o mercado de trabalho. `Formacoes` possuem algumas características importantes, como `nome`, `nivel` e seus respectivos `conteudosEducacionais`. Além disso, tais experiências educacionais têm um comportamento relevante ao nosso domínio, definido pela capacidade de `matricular` um ou mais `Alunos`.**


```kotlin
TODO("Crie uma solução em Koltin abstraindo esse domínio. O arquivo [desafio.kt] te ajudará 😉")
```

# Desafio Kotlin: Plataforma Educacional Simples

Este projeto é uma implementação completa do desafio proposto no Kotlin Playground [](https://pl.kotl.in/WcteahpyN), inspirado no curso "Kotlin com Android" de Kassiano Resende (Casa do Código, 2020).

O objetivo foi modelar um sistema básico de plataforma educacional (similar à DIO ou Alura), com:

- Usuários
- Conteúdos educacionais (aulas/módulos)
- Formações (cursos) que agrupam conteúdos
- Matrícula de usuários em formações
- Cálculo de duração total e exibição de inscritos

## O que foi feito

- **Enum Nivel**: Definido com níveis Básico, Intermediário e Difícil (ainda não usado, mas pronto para evolução).
- **Classe Usuario**: Simples, com nome e override de `toString()` para exibição limpa.
- **Data class ConteudoEducacional**: Representa uma aula com nome e duração (padrão 60 minutos). Tem override de `toString()` para formato legível.
- **Data class Formacao**: 
  - Agrupa nome e lista de conteúdos.
  - Mantém lista mutável de inscritos (`mutableListOf<Usuario>()`).
  - Método `matricular(usuario)`: adiciona usuário se ainda não estiver inscrito e informa o resultado via `println`.
  - Método auxiliar `duracaoTotal()`: soma as durações dos conteúdos usando `sumOf`.
  - Método auxiliar `exibirInscritos()`: lista os inscritos numerados ou informa se está vazio.
- **Função main()**:
  - Cria 4 conteúdos educacionais reais (com durações variadas).
  - Cria 2 formações: "Kotlin Básico" e "Kotlin Avançado".
  - Cria 3 usuários (Henry, Ana e João).
  - Simula matrículas (incluindo tentativa duplicada para testar a verificação).
  - Exibe resultados detalhados de cada formação (conteúdos, duração total, inscritos).
  - Lista ideias de evolução no final.

## Como rodar

### Opção 1: Kotlin Playground (mais rápida)
1. Acesse: https://pl.kotl.in/WcteahpyN
2. Cole o código completo do arquivo `desafio.kts`
3. Clique em **Run** → veja a saída no console.

### Opção 2: Localmente com Kotlin CLI
1. Certifique-se de ter o Kotlin instalado (`kotlinc -version`).
2. Salve o código como `desafio.kts`.
3. No terminal/PowerShell:
   ```bash
   kotlinc -script desafio.kts