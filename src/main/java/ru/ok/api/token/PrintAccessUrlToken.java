package ru.ok.api.token;

import ru.ok.api.auth.OkAuthorization;

public class PrintAccessUrlToken {

    public static void main(String[] args) {
        System.out.println("Visit this URL to authorize and get the code: ");
        System.out.println(OkAuthorization.getAuthorizationUrl());
        System.out.println("\nAfter authorization, paste the code parameter from the redirect URL below");
    }
}
