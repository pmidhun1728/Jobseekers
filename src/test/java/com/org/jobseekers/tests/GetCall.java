package com.org.jobseekers.tests;

import io.restassured.response.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;

import static  io.restassured.RestAssured.*;

public class GetCall {

    int expId = 7845690;
    String expEmail = "cdwvc43242@gmail.com";

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
                /*.body("id[0]", equalTo(7845690))
                .body("name[0]",equalTo("Test"))
                .body("email[0]",equalTo("cdwvc43242@gmail.com"))
                .body("gender[0]",equalTo("male"))
                .body("status[0]",equalTo("active")) */
                .log().everything()
                .extract().response();

        response.prettyPrint();
        List<Integer> resId = response.jsonPath().getList("id");
        for (int id : resId) {
            if (id == expId)
            {
                Assert.assertEquals(id,expId);
                //System.out.println("this is correct");
            }
        }
        int getStatusCode= response.getStatusCode();
        Assert.assertEquals(getStatusCode, 200);
    }

    @Test
    public void getCall(){

        String url = "https://reqres.in/api/users";

        Response response = given()
                .header("Content-Type", "application/json")
                .queryParam("page", 2)
                .when()
                .get(url)
                .then()
                .log().everything()
                .extract().response();

        int getStatusCode =  response.getStatusCode();
        Assert.assertEquals(getStatusCode, 200);

        int getId = response.jsonPath().getInt("data.id[0]");
        System.out.println(getId);
        Assert.assertEquals(getId, 7);

        String getEmail = response.jsonPath().getString("data[2].email");
        System.out.println(getEmail);
        Assert.assertFalse(getEmail.isEmpty(), "Email is not Empty");
    }
}
