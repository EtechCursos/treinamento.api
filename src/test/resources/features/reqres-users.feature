#language: pt
#enconding: UTF-8
#Author: Victor Neves

Funcionalidade: Endpoint users

  @getUsers
  Cenario: Pegar pagina da lista de usuários
    Dado que eu escolha a página "1" para pesquisa
    Quando realizar uma requisição GET na url "https://reqres.in/api/users?page={page}"
    Então devo receber o status "200"
    E devo receber a chave "data" no retorno do serviço

  @getUser
  Cenario: Pegar usuário por id
    Dado que eu escolha a id de usuário "2" para pesquisa
    Quando realizar uma requisição GET na url "https://reqres.in/api/users/{id}"
    Então devo receber o status "200"
    E devo receber a chave "data" no retorno do serviço

  @getInvalidUser
  Cenario: Pegar usuário inválido
    Dado que eu escolha a id de usuário "99" para pesquisa
    Quando realizar uma requisição GET na url "https://reqres.in/api/users/{id}"
    Então devo receber o status "404"