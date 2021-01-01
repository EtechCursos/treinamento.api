package br.com.etech.api.funcionalidades;

import br.com.etech.commons.ApiRobot;
import org.junit.Assert;

public class ReqResUsersFuncionalidade {

    private ApiRobot apiRobot;

    public ReqResUsersFuncionalidade() {
        apiRobot = new ApiRobot();
    }

    public void addPageNumberParam(String pageNumber) {
        apiRobot.addRequestParam("page", pageNumber);
    }

    public void requestUsersList(String url) {
        apiRobot.getRequest(url);
    }


    public void checkStatus(String status) {
        Assert.assertTrue(Integer.parseInt(status) == apiRobot.getStatusCode());
    }

    public void checkKey(String key) {
        Assert.assertNotNull(apiRobot.getResponseBody().path(key));
    }
}
