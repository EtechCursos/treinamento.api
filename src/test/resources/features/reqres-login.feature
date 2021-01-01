#language: pt
#encoding: UTF-8
#Author: Victor Neves

Funcionalidade: Endpoint login

  @successfulLogin
  Cenario: Login com sucesso
    Dado que eu passe o email "eve.holt@reqres.in" e a senha "cityslicka" no body da requisição
    Quando realizar uma requisição "POST" na url "https://reqres.in/api/login/"
    Então devo receber o status "200"
    E devo receber a chave "token" no retorno do serviço

  @unsuccessfulLogin
  Cenario: Login sem sucesso
    Dado que eu passe o email "peter@klaven" no body da requisição
    Quando realizar uma requisição "POST" na url "https://reqres.in/api/login/"
    Então devo receber o status "400"
    E devo receber a chave "error" no retorno do serviço