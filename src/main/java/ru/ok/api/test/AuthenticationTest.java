package ru.ok.api.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ok.api.auth.OkApiConfig;
import ru.ok.api.auth.OkAuthorization;

public class AuthenticationTest extends BaseTest{

    @Test
    public void testAccessToken(){
        Response response = OkAuthorization.getAccessToken(authCode);

        System.out.println("Response:");
        response.prettyPrint();

        Assertions.assertNotNull(OkApiConfig.ACCESS_TOKEN);
        Assertions.assertFalse(OkApiConfig.ACCESS_TOKEN.isEmpty());
        Assertions.assertNotNull(OkApiConfig.REFRESH_TOKEN);
        Assertions.assertFalse(OkApiConfig.REFRESH_TOKEN.isEmpty());
    }
}
