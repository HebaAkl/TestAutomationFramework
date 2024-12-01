package backend;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class CustomRestAssured {

    private String jwt;
    private Object body;
    private String key;
    private int maxTrials;
    private Boolean enableRetry;
    private Response response = null;
    private int retry = 0;

    private CustomRestAssured() {
        // Note: Private constructor to prevent direct instantiation
    }

    public static CustomRestAssured given() {
        return new CustomRestAssured();
    }

    public CustomRestAssured header(String jwt) {
        this.jwt = jwt;
        return this;
    }

    public CustomRestAssured body(Object body) {
        this.body = body;
        return this;
    }

    public CustomRestAssured key(String key) {
        this.key = key;
        return this;
    }

    public CustomRestAssured trials(int maxTrials) {
        this.maxTrials = maxTrials;
        return this;
    }

    public CustomRestAssured enableRetry(Boolean enableRetry) {
        this.enableRetry = enableRetry;
        return this;
    }

    public Response post(String url) {
        while (retry <= maxTrials){
            response = RestAssured
                    .given()
                    .header("Authorization", jwt)
                    .contentType(ContentType.JSON)
                    .body(body)
                    .when()
                    .post(url);

            if (enableRetry && !hasError(response, key)) {
                return response;
            } else {
                ++ retry;
            }

        }

        return response;
    }

    private Boolean hasError( Response response, String key) {
        // Note: data and errors depend on the returned response, it's better to be initialized in say config to avoid depend on static data
        JSONObject responseObj = new org.json.JSONObject(response.asString());
        JSONObject data = responseObj.getJSONObject("data").getJSONObject(key);
        if(data.get("errors") != null){
            return true;
        }
        return false;
    }
}