package br.com.etech.api.funcionalidades;

import br.com.etech.commons.ApiRobot;
import org.junit.Assert;

public class ReqResUsersFuncionalidade {

    private ApiRobot apiRobot;

    public ReqResUsersFuncionalidade() {
        apiRobot = new ApiRobot();
    }

    public void addRequestParam(String key, String value) {
        apiRobot.addRequestParam(key, value);
    }

    public void addToRequestBody(String key, String value) {
        apiRobot.addToRequestBody(key, value);
    }

    public void request(String method, String url) {
        switch (method) {
            case "GET":
                this.apiRobot.getRequest(url);
                break;
            case "POST":
                this.apiRobot.postRequest(url);
                break;
            case "PUT":
                this.apiRobot.putRequest(url);
                break;
            case "DELETE":
                this.apiRobot.deleteRequest(url);
                break;
        }
    }

    public void checkStatus(String status) {
        Assert.assertTrue(Integer.parseInt(status) == apiRobot.getStatusCode());
    }

    public void checkKey(String key) {
        Assert.assertNotNull(apiRobot.getResponseBody().path(key));
    }


}
