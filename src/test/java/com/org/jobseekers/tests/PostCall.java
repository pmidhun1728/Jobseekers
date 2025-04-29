package com.org.jobseekers.tests;

import com.org.jobseekers.utils.FakerClass;
import com.org.jobseekers.utils.RequestPayload;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PostCall {

    @Test
    public void postRequest(){

        String url = "https://gorest.co.in/public/v2/users";
        RequestPayload requestPayload = new RequestPayload(1, "Midhun", FakerClass.getEmail(), "Male", "Active");

        Response response = given()
                .log().everything()
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .header("Authorization", "Bearer 9cee3cf96dbafa82ff98cc1f76c3fbf650db688bb5024a446d01ed8e0ffa03d7")
                .body(requestPayload)
                .when()
                .post(url)
                .then()
                .log().everything()
                .extract().response();

                 response.prettyPrint();

        int getStatusCode= response.getStatusCode();
        Assert.assertEquals(getStatusCode, 201);

       String getEmail = response.jsonPath().getString("id");
        System.out.println(getEmail);

        Assert.assertEquals(getEmail, "albert123@gmail.com");

    }

}
