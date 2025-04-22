package com.org.jobseekers.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class PojoSetData
{
	@Test
	public void pojousingSetData()
	{
		GoResRequestPutLoad data = new GoResRequestPutLoad("Jaya", "SDET1", "38");

			 given()
				
				   .contentType("application/json")
				   .body(data.toString())
				.when()
				   .get("https://reqres.in/api/users")
				   
				.then()				   
				   .body ("name" , equalTo ("Jay"))
				   .body ("job", equalTo ("SDET"))
			       .body ("id", equalTo ("717"))			      
			       .header ("content-type","application/json; charset=utf-8")
				   .log().everything()
				   .statusCode (201)
				   .extract().response();
				
		
	}				
}
	
	   
	   
	   
	
	
	
