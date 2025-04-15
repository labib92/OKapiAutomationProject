package ru.ok.api.test;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ok.api.group.GroupApiService;

public class EditPhotoTest extends BaseTest{

    @Test
    public void testEditPhoto(){
        groupApiService = new GroupApiService();
        Response response = groupApiService.editPhoto();

        System.out.println("Response:");
        response.prettyPrint();

        //Basic status code check
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
