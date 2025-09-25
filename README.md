# Atividade: Spring Data JPA com Filmes e Diretores

### OBSERVAÇÃO

Será necessário criar um novo projeto com os seguintes starters:
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok

---

### ENUNCIADO

### Filme e FilmeRepository

**(1,0)** Crie uma nova entidade chamada `Filme` com os seguintes atributos:
- `id`: identificador único do filme (tipo `Long`)
- `titulo`: título do filme (tipo `String`)
- `duracao`: duração do filme em minutos (tipo `Integer`)

**(1,0)** Crie um repositório Spring Data JPA chamado `FilmeRepository` que estende a interface `JpaRepository`. Este repositório deve ter:
- Um método que retorne todos os filmes com duração maior que um determinado valor.
    - O método deve receber um parâmetro do tipo `Integer` chamado `duracao`.
    - Deve retornar uma lista de filmes com duração maior que o valor informado.
- Um método que retorne todos os filmes com duração menor ou igual a um determinado valor.
    - O método deve receber um parâmetro do tipo `Integer` chamado `duracao`.
    - Deve retornar uma lista de filmes com duração menor ou igual ao valor informado.
- Um método que retorne todos os filmes cujo título comece com um determinado texto.
    - O método deve receber um parâmetro do tipo `String` chamado `titulo`.
    - Deve retornar uma lista de filmes cujo título comece com o texto informado.

**(1,0)** Crie os testes na classe principal que insira pelo menos **3 filmes** e demonstre que **esses métodos estão funcionando corretamente** (pode ser apenas com `System.out.println()` no console).

---

### Diretor e DiretorRepository

**(1,0)** Crie uma nova entidade chamada `Diretor` com os seguintes atributos:
- `id`: identificador único do diretor (tipo `Long`)
- `nome`: nome do diretor (tipo `String`)

**(1,0)** Cada diretor pode ter vários filmes associados a ele, mas um filme pertence a apenas um diretor. Implemente esse relacionamento entre as entidades `Diretor` e `Filme` usando a anotação correta do JPA.

**(1,0)** Crie um repositório Spring Data JPA chamado `DiretorRepository`, também estendendo `JpaRepository`, com os seguintes métodos:
- Um método que retorne todos os diretores cujo nome comece com um determinado valor.
    - O método deve receber um parâmetro `nome` do tipo `String`.
    - Deve retornar uma lista de diretores cujo nome começa com esse valor.
- Um método que retorne um diretor específico pelo ID, incluindo todos os seus filmes relacionados.
    - Para isso, utilize `@Query` com `LEFT JOIN FETCH`.

**(1,0)** Crie um exemplo que insira pelo menos **2 diretores com filmes associados** e demonstre que esses métodos estão funcionando corretamente com `System.out.println()` no console.
