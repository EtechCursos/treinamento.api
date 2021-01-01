#language: pt
#enconding: UTF-8
#Author: Victor Neves

Funcionalidade: Endpoint users

  @getUsers
  Cenario: Pegar pagina da lista de usuários
    Dado que eu escolha a página "1" para pesquisa
    Quando realizar uma requisição "GET" na url "https://reqres.in/api/users?page={page}"
    Então devo receber o status "200"
    E devo receber a chave "data" no retorno do serviço

  @getUsersWithDelay
  Cenario: Pegar pagina da lista de usuários com delay
    Dado que eu escolha o valor "3" para o delay da pesquisa
    Quando realizar uma requisição "GET" na url "https://reqres.in/api/users?delay={delay}"
    Então devo receber o status "200"
    E devo receber a chave "data" no retorno do serviço

  @getUser
  Cenario: Pegar usuário por id
    Dado que eu escolha a id de usuário "2" para pesquisa
    Quando realizar uma requisição "GET" na url "https://reqres.in/api/users/{id}"
    Então devo receber o status "200"
    E devo receber a chave "data" no retorno do serviço

  @getInvalidUser
  Cenario: Pegar usuário inválido
    Dado que eu escolha a id de usuário "99" para pesquisa
    Quando realizar uma requisição "GET" na url "https://reqres.in/api/users/{id}"
    Então devo receber o status "404"

  @createUser
  Cenario: Criar usuário
    Dado que eu passe o nome "victor" e o cargo "trainee" no body da requisição
    Quando realizar uma requisição "POST" na url "https://reqres.in/api/users"
    Então devo receber o status "201"
    E devo receber a chave "id" no retorno do serviço

  @updateUser
  Cenario: Atualizar usuário
    Dado que eu passe o nome "victor" e o cargo "QA" no body da requisição
    Quando realizar uma requisição "PUT" na url "https://reqres.in/api/users"
    Então devo receber o status "200"
    E devo receber a chave "updatedAt" no retorno do serviço

  @deleteUser
  Cenario: deletar usuário
    Dado que eu escolha a id de usuário "2" para pesquisa
    Quando realizar uma requisição "DELETE" na url "https://reqres.in/api/users/{id}"
    Então devo receber o status "204"