package ru.ok.api.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ok.api.auth.OkApiConfig;
import ru.ok.api.auth.OkAuthorization;

public class AuthenticationTest {

    @Test
    public void testAccessToken(){
        // Replace with the code you get from the redirect URL
        String authCode = "";

        OkAuthorization.getAccessToken(authCode);

        Assertions.assertNotNull(OkApiConfig.ACCESS_TOKEN);
        Assertions.assertFalse(OkApiConfig.ACCESS_TOKEN.isEmpty());
        Assertions.assertNotNull(OkApiConfig.REFRESH_TOKEN);
        Assertions.assertFalse(OkApiConfig.REFRESH_TOKEN.isEmpty());

        System.out.println("access_token: " + OkApiConfig.ACCESS_TOKEN);
        System.out.println("access_token: " + OkApiConfig.REFRESH_TOKEN);
    }
}
