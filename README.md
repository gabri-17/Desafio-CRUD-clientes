**Módulo: Back end**
**Capítulo: API REST, camadas, CRUD, exceções,**
**validações**
---

## DESAFIO: CRUD de clientes 
### _Forma de entrega: link do projeto no Github_

Você deverá entregar um projeto Spring Boot contendo um CRUD completo de web services REST para
acessar um recurso de clientes, contendo as cinco operações básicas aprendidas no capítulo:
- Busca paginada de recursos
- Busca de recurso por id
- Inserir novo recurso
- Atualizar recurso
- Deletar recurso

O projeto deverá estar com um ambiente de testes configurado acessando o banco de dados H2, deverá usar
Maven como gerenciador de dependência, e Java como linguagem.

![Diagrama UML de Client](https://camo.githubusercontent.com/38c5515f4d65e6ba8197d11fa378ff133341299c2357973a88f4691eb517df35/68747470733a2f2f692e6962622e636f2f6b33677a4254772f696d6167652d323032342d30372d31322d5430302d31322d32382d3237382d5a2e706e67)

**Seu projeto deverá fazer um seed de pelo menos 10 clientes** com dados SIGNIFICATIVOS (não é para
usar dados sem significado como “Nome 1”, “Nome 2”, etc.).

**Seu projeto deverá tratar as seguintes exceções:**
- Id não encontrado (para GET por id, PUT e DELETE), retornando código 404.
- Erro de validação, retornando código 422 e mensagens customizada para cada campo inválido. As
regras de validação são:
    - Nome: não pode ser vazio
    - Data de nascimento: não pode ser data futura (dica: use @PastOrPresent)

**_Atenção_**: crie um **novo projeto** para este trabalho. Não é para simplesmente acrescentar a classe
Client no projeto feitos nas aulas.

**_Atenção_**: lembre-se de que por padrão a JPA transforma nomes de atributos em camelCase para
snake_case, como foi o caso do campo imgUrl das aulas, que no banco de dados tinha o nome
img_url. Assim, **o campo birthDate acima será criado no banco de dados como birth_date, então
seu script SQL deverá seguir este padrão.**

**_Atenção_**: cuidado para não salvar no seu projeto arquivos e pastas que não devem ser salvas no Git,
tais como a pasta .metadata do Eclipse ou .idea do Intellij.
