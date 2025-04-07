package ru.ok.api.token;

import ru.ok.api.auth.OkAuthorization;

public class PrintAccessUrlToken {

    public static void main(String[] args) {
        System.out.println("Visit this URL to authorize and get the code: ");
        System.out.println("1. Visit the URL in browser");
        System.out.println(OkAuthorization.getAuthorizationUrl());
        System.out.println("2. Authenticate and approve permissions");
        System.out.println("3. After authorization, paste the code parameter from the redirect URL to authCode String" +
                " in BaseTest class");
    }
}
