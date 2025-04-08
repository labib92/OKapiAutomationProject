package ru.ok.api.auth;

public class OkApiConfig {
    public static final String APPLICATION_ID = "YOUR_APPLICATION_ID";
    public static final String APPLICATION_KEY = "YOUR_APPLICATION_KEY";
    public static final String CLIENT_SECRET = "YOUR_CLIENT_SECRET";
    public static final String REDIRECT_URL = "YOUR_REDIRECT_URL";

    public static final String TOKEN_URI = "https://api.ok.ru";
    public static final String AUTH_URI = "https://connect.ok.ru";

    public static final String METHOD_GET_USER_GROUP_V2 = "group.getUserGroupsV2";
    public static final String METHOD_GET_COUNTERS = "group.getCounters";
    public static final String FORMAT = "json";
    public static final String COUNTER_TYPES = "PHOTOS,PHOTO_ALBUMS,VIDEOS";

    public static String ACCESS_TOKEN;
    public static String REFRESH_TOKEN;
    public static String GROUP_ID;
    public static String USER_ID;
    public static String STATUS;
}

