package ru.ok.api.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ok.api.auth.OkApiConfig;
import ru.ok.api.group.GroupApiService;


public class GetUserGroupsV2Test extends BaseTest{

    @Test
    public void testGetUserGroupsV2Success(){
        groupApiService = new GroupApiService();
        Response response = groupApiService.getUserGroupsV2();

        OkApiConfig.GROUP_ID = response.jsonPath().getString("groups[0].groupId");
        OkApiConfig.USER_ID = response.jsonPath().getString("groups[0].userId");
        OkApiConfig.STATUS = response.jsonPath().getString("groups[0].status");
        System.out.println("GROUP_ID = "+OkApiConfig.GROUP_ID);
        System.out.println("USER_ID = "+OkApiConfig.USER_ID);
        System.out.println("STATUS = "+OkApiConfig.STATUS);

        //Print response
        System.out.println("Response:");
        response.prettyPrint();

        //Basic status code check
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
