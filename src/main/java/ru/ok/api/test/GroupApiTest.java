package ru.ok.api.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ok.api.group.GroupApiService;


public class GroupApiTest extends BaseTest{
    private GroupApiService groupApiService;

    @Test
    public void testGetUserGroupsV2Success(){
        groupApiService = new GroupApiService();
        Response response = groupApiService.getUserGroupsV2();

        //Print response
        System.out.println("Response:");
        response.prettyPrint();

        //Basic status code check
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
