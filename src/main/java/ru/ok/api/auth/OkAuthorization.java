package ru.ok.api.auth;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class OkAuthorization {

    public static Response getAccessToken(String authCode){
        Map<String ,String> formParameters = new HashMap<String, String>();
        formParameters.put("code", authCode);
        formParameters.put("client_id", OkApiConfig.APPLICATION_ID);
        formParameters.put("client_secret", OkApiConfig.CLIENT_SECRET);
        formParameters.put("redirect_uri", OkApiConfig.REDIRECT_URL);
        formParameters.put("grant_type", "authorization_code");

        Response response = given()
                .baseUri(OkApiConfig.TOKEN_URI)
                .formParams(formParameters)
                .when()
                .post("/oauth/token.do");

        OkApiConfig.ACCESS_TOKEN = response.jsonPath().getString("access_token");
        OkApiConfig.REFRESH_TOKEN = response.jsonPath().getString("refresh_token");

        return response;
    }

    public static String getAuthorizationUrl(){
        return OkApiConfig.AUTH_URI+"/oauth/authorize?"+
                "client_id="+OkApiConfig.APPLICATION_ID+
                "&scope=VALUABLE_ACCESS"+
                "&response_type=code"+
                "&redirect_uri="+OkApiConfig.REDIRECT_URL;
    }
}
