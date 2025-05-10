package com.org.jobseekers.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PojoSetData
{
	@Test
	public void pojousingSetData()
	{
		GoResRequestPutLoad data = new GoResRequestPutLoad ("Jai","SDET","717");
		

		 String url = ("https://reqres.in/api/users");
			
		 
		     given()
				   .contentType("application/json")
				   .body(data.toString())
				   
				   .when()
				   .get(url)
				   
				.then()				   
				   .body ("name" , equalTo ("Jai"))
				   .body ("job", equalTo ("SDET"))
			       .body ("id", equalTo ("717"))			      
			       .header ("content-type","application/json; charset=utf-8")
			       
				   .log().everything()
				   .statusCode (201)
				   .extract().response();
				
		
	}

}
	
	   
	   
	   
	
	
	
