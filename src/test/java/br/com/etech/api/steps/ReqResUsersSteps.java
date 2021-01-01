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

    @Dado("^que eu escolha a página \"([^\"]*)\" para pesquisa$")
    public void queEuEscolhaAPaginaParaPesquisa(String pageNumber) {
        this.reqResUsersFuncionalidade.addRequestParam("page", pageNumber);
    }

    @Dado("^que eu escolha a id de usuário \"([^\"]*)\" para pesquisa$")
    public void queEuEscolhaAIdDeUsuarioParaPesquisa(String id) {
        this.reqResUsersFuncionalidade.addRequestParam("id", id);
    }

    @Dado("^que eu passe o nome \"([^\"]*)\" e o cargo \"([^\"]*)\" no body da requisição$")
    public void queEuPasseONomeEOCargoNoBodyDaRequisicao(String name, String job) {
        this.reqResUsersFuncionalidade.addToRequestBody("name", name);
        this.reqResUsersFuncionalidade.addToRequestBody("job", job);
    }

    @Dado("^que eu escolha o valor \"([^\"]*)\" para o delay da pesquisa$")
    public void queEuEscolhaOValorParaODelayDaPesquisa(String delay) {
        this.reqResUsersFuncionalidade.addRequestParam("delay", delay);
    }

    @Quando("^realizar uma requisição \"([^\"]*)\" na url \"([^\"]*)\"$")
    public void realizarUmaRequisicaoNaUrl(String method, String url) {
        this.reqResUsersFuncionalidade.request(method, url);
    }

    @Dado("^que eu passe o email \"([^\"]*)\" e a senha \"([^\"]*)\" no body da requisição$")
    public void queEuPasseOEmailEASenhaNoBodyDaRequisicao(String email, String password) {
        this.reqResUsersFuncionalidade.addToRequestBody("email", email);
        this.reqResUsersFuncionalidade.addToRequestBody("password", password);
    }

    @Dado("^que eu passe o email \"([^\"]*)\" no body da requisição$")
    public void queEuPasseOEmailNoBodyDaRequisição(String email) {
        this.reqResUsersFuncionalidade.addToRequestBody("email", email);
    }

    @Então("^devo receber o status \"([^\"]*)\"$")
    public void devoReceberOStatus(String status) {
        this.reqResUsersFuncionalidade.checkStatus(status);
    }

    @E("^devo receber a chave \"([^\"]*)\" no retorno do serviço$")
    public void devoReceberAChaveNoRetornoDoServico(String key) {
        this.reqResUsersFuncionalidade.checkKey(key);
    }



}
