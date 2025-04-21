package com.org.jobseekers.tests;

import io.restassured.response.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetCall {


    @Test
    public void getCallRequest()
    {
        String url = "https://gorest.co.in/public/v2/users";
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 9cee3cf96dbafa82ff98cc1f76c3fbf650db688bb5024a446d01ed8e0ffa03d7")
                .when()
                .get(url)
                .then()
                .body("id[0]", equalTo(7845690))
                .body("name[0]",equalTo("Test"))
                .body("email[0]",equalTo("cdwvc43242@gmail.com"))
                .body("gender[0]",equalTo("male"))
                .body("status[0]",equalTo("active"))
                .log().everything()
                .extract().response();

        response.prettyPrint();
        int getStatusCode= response.getStatusCode();
        Assert.assertEquals(getStatusCode, 200);
    }
}
