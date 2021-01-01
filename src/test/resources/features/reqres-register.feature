#language: pt
#encoding: UTF-8
#Author: Victor Neves

Funcionalidade: Endpoint register

  @registerUser
  Cenario: Registrar usuário com sucesso
    Dado que eu passe o email "michael.lawson@reqres.in" e a senha "pistol" no body da requisição
    Quando realizar uma requisição "POST" na url "https://reqres.in/api/register/"
    Então devo receber o status "200"
    E devo receber a chave "id" no retorno do serviço

  @registerInvalidUser
  Cenario: Registrar usuário sem sucesso
    Dado que eu passe o email "michael.lawson@reqres.in" no body da requisição
    Quando realizar uma requisição "POST" na url "https://reqres.in/api/register/"
    Então devo receber o status "400"
    E devo receber a chave "error" no retorno do serviço