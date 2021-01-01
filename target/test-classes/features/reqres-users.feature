#language: pt
#enconding: UTF-8
#Author: Victor Neves

Funcionalidade: Endpoint users

  @getUsers
  Cenario: Pegar lista de usuários
    Dado que eu escolha a página "1" para pesquisa
    Quando realizar uma requisição GET na url "https://reqres.in/api/users?page={page}"
    Então devo receber o status "200"
    E devo receber a chave "data" no retorno do serviço