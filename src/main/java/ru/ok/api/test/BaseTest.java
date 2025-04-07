package ru.ok.api.test;

import org.junit.jupiter.api.BeforeAll;
import ru.ok.api.auth.OkAuthorization;

public class BaseTest {
    // Replace with the code you get from the redirect URL
    protected static String authCode = "Read PrintAccessUrlToken class";
    @BeforeAll
    public static void setupClass(){
        System.out.println("Exchanging code 'authCode' for token.");
        OkAuthorization.getAccessToken(authCode);
        System.out.println("\nToken successfully received");
    }

}
