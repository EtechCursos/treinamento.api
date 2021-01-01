package br.com.etech.api.steps;

import br.com.etech.api.funcionalidades.ReqResUsersFuncionalidade;
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

    @Dado("^que eu escolha a página \"([^\"]*)\" para pesquisa$")
    public void queEuEscolhaAPáginaParaPesquisa(String pageNumber) {
        this.reqResUsersFuncionalidade.addPageNumberParam(pageNumber);
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
