package com.org.jobseekers.tests;

import com.fasterxml.jackson.core.util.RequestPayload;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PostCall {

    @Test
    public void postRequest(){

        String url = "https://gorest.co.in/public/v2/users";
//       RequestPayload requestPayload = new RequestPayload(1, "FirstName", "albert123@gmail.com", "Male", "active");

        Response response = given()
                .log().everything()
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .header("Authorization", "Bearer 9cee3cf96dbafa82ff98cc1f76c3fbf650db688bb5024a446d01ed8e0ffa03d7")
//                .body()
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



        //Given

        // header
        // path paratmeter
        // query paramenter
        //Authenticatio and authorization
        //Cookies
        //Body

        // Body

        // HashMap
        //Json File
        //POJO (plain old java object)







    }

}
