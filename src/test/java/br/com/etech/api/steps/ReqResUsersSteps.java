package br.com.etech.api.steps;

import br.com.etech.api.funcionalidades.ReqResUsersFuncionalidade;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class ReqResUsersSteps {

    private ReqResUsersFuncionalidade reqResUsersFuncionalidade;

    public ReqResUsersSteps() {
        reqResUsersFuncionalidade = new ReqResUsersFuncionalidade();
    }

    @Quando("^realizar uma requisição GET na url \"([^\"]*)\"$")
    public void realizarUmaRequisiçãoGETNoEndpoint(String url) {
        this.reqResUsersFuncionalidade.requestUsersList(url);;
    }

    @Quando("^realizar uma requisição \"([^\"]*)\" na url \"([^\"]*)\"$")
    public void realizarUmaRequisiçãoNaUrl(String method, String url) {
        this.reqResUsersFuncionalidade.request(method, url);
    }

    @Dado("^que eu escolha a página \"([^\"]*)\" para pesquisa$")
    public void queEuEscolhaAPáginaParaPesquisa(String pageNumber) {
        this.reqResUsersFuncionalidade.addRequestParam("page", pageNumber);
    }

    @Então("^devo receber o status \"([^\"]*)\"$")
    public void devoReceberOStatus(String status) {
        this.reqResUsersFuncionalidade.checkStatus(status);
    }

    @E("^devo receber a chave \"([^\"]*)\" no retorno do serviço$")
    public void devoReceberAChaveNoRetornoDoServico(String key) {
        this.reqResUsersFuncionalidade.checkKey(key);
    }


    @Dado("^que eu escolha a id de usuário \"([^\"]*)\" para pesquisa$")
    public void queEuEscolhaAIdDeUsuarioParaPesquisa(String id) {
        this.reqResUsersFuncionalidade.addRequestParam("id", id);
    }

    @Dado("^que eu passe o nome \"([^\"]*)\" e o cargo \"([^\"]*)\" no body da requisição$")
    public void queEuPasseONomeEOCargoNoBodyDaRequisição(String name, String job) {
        this.reqResUsersFuncionalidade.addToRequestBody("name", name);
        this.reqResUsersFuncionalidade.addToRequestBody("job", job);
    }


}
