package com.org.jobseekers.commons;

import com.org.jobseekers.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Base {

    public static RequestSpecification requestSpecification;
    public static RequestSpecification upgradeSpec;

    public Base() {
        RestAssured.baseURI = ConfigReader.getProperty("url");
        RestAssured.baseURI = ConfigReader.getProperty("base_url");

        requestSpecification = given()
                .log().everything()
                .header("Content-Type", "application/json")
                .header("accept", "application/json")
                .header("Authorization", "Bearer 9cee3cf96dbafa82ff98cc1f76c3fbf650db688bb5024a446d01ed8e0ffa03d7");


        upgradeSpec = given()
                .log().everything()
                .header("Content-Type", "application/json");
    }

    public Response postRequest(String endPoint, Object body){
        return requestSpecification.body(body).post(endPoint);
    }

    public Response putRequest(String endPoint, Object body){
        return requestSpecification.body(body).put(endPoint);
    }

    public  Response getCall(String endPoint){
        return requestSpecification.get(endPoint);
    }

    public Response getUpgrade(String endPoint){
        return upgradeSpec.get(endPoint);
    }


}
