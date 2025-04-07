package ru.ok.api.group;

import io.restassured.response.Response;
import org.apache.commons.codec.digest.DigestUtils;
import ru.ok.api.auth.OkApiConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static io.restassured.RestAssured.given;

public class GroupApiService {
    /*
    * Generates the OK.ru API signature:
    * sig = md5(sorted_params_string + md5(access_token + client_secret))
    */
    private String generateSignature(Map<String, String> parameters){
        // 1. Sort all parameters alphabetically
        SortedMap<String, String> sortedMap = new TreeMap<String, String>(parameters);

        // 2. Build query string
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<String, String> entry : sortedMap.entrySet()){
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
        }

        // 3. Append md5(access_token + client_secret)
        String inner = DigestUtils.md2Hex(OkApiConfig.ACCESS_TOKEN+OkApiConfig.CLIENT_SECRET);
        stringBuilder.append(inner);

        // 4. Final MD5 hash
        return DigestUtils.md2Hex(stringBuilder.toString());
    }

    public Response getUserGroupsV2(){
        Map<String, String> queryParameters = new HashMap<String, String>();
        queryParameters.put("application_key", OkApiConfig.APPLICATION_KEY);
        queryParameters.put("format", OkApiConfig.FORMAT);
        queryParameters.put("method",OkApiConfig.METHOD);
        queryParameters.put("access_token", OkApiConfig.ACCESS_TOKEN);

        //add signature
        String sig = generateSignature(queryParameters);
        System.out.println("sig = "+sig);
        queryParameters.put("sig", sig);

        return given()
                .baseUri(OkApiConfig.TOKEN_URI+"/fb.do")
                .queryParams(queryParameters)
                .when()
                .get();
    }
}
