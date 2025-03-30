package ru.ok.api.test;

import org.junit.jupiter.api.BeforeAll;
import ru.ok.api.auth.OkAuthorization;

public class BaseTest {

    @BeforeAll
    public static void setup(){
        System.out.println("Visit this URL to authorize and get the code: ");
        System.out.println(OkAuthorization.getAuthorizationUrl());
        System.out.println("\nAfter authorization, paste the code parameter from the redirect URL below");
    }

}
