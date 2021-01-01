package br.com.etech.commons;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ApiRobot {

    private final Map<String, String> requestParams;
    private final Map<String, String> requestBody;
    private final Map<String, String> requestHeaders;
    private ResponseBody responseBody;
    private Map<String, String> cookies;
    private Integer statusCode;

    public ApiRobot() {
        requestParams = new HashMap<String, String>();
        requestBody = new HashMap<String, String>();
        requestHeaders = new HashMap<String, String>();
    }

    public void getRequest(String url) {
        Response response =
            given()
                .pathParams(getRequestParams())
                .body(getRequestBody())
            .when()
                .get(url)
            .then()
                .log().all()
                .extract().response();

        setStatusCode(response.statusCode());
        setResponseBody(response.getBody());
        setCookies(response.getCookies());
    }

    public void postRequest(String url) {
        Response response =
            given()
                .contentType("application/json; charset=utf-8")
                .body(getRequestBody())
                .pathParams(getRequestParams())
            .when()
                .post(url)
            .then()
                .log().all()
                .extract().response();

        setStatusCode(response.statusCode());
        setResponseBody(response.getBody());
        setCookies(response.getCookies());
    }

    public void putRequest(String url) {
        Response response =
            given()
                .contentType("application/json; charset=utf-8")
                .pathParams(getRequestParams())
                .body(getRequestBody())
            .when()
                .put(url)
            .then()
                .log().all()
                .extract().response();

        setStatusCode(response.statusCode());
        setResponseBody(response.getBody());
        setCookies(response.getCookies());
    }

    public void deleteRequest(String url) {
        Response response =
            given()
                .contentType("application/json; charset=utf-8")
                .pathParams(getRequestParams())
                .body(getRequestBody())
            .when()
                .delete(url)
            .then()
                .log().all()
                .extract().response();

        setStatusCode(response.statusCode());
        setResponseBody(response.getBody());
        setCookies(response.getCookies());
    }

    public Map<String, String> getRequestParams() {
        return requestParams;
    }

    public void addRequestParam(String key, String value) {
        this.requestParams.put(key, value);
    }

    public Map<String, String> getRequestBody() {
        return requestBody;
    }

    public void addToRequestBody(String key, String value) {
        this.requestBody.put(key, value);
    }

    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public void addToRequestHeader(String key, String value) {
        this.requestHeaders.put(key, value);
    }

    public ResponseBody getResponseBody() {
        return responseBody;
    }

    private void setResponseBody(ResponseBody responseBody) {
        this.responseBody = responseBody;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    private void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    private void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
