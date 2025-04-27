package com.org.jobseekers.tests;

import com.org.jobseekers.commons.Base;
import com.org.jobseekers.utils.FakerClass;
import com.org.jobseekers.utils.RequestPayload;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GoResPost extends Base {
   private FakerClass fakerClass;

    @Test
    public void postCall(){

        RequestPayload requestPayload = new RequestPayload(1, "Midhun", FakerClass.getEmail(), "Male", "Active");
        Response response = postRequest("public/v2/users", requestPayload);

        response.prettyPrint();
    }

    @Test
    public void getCall(){
        Response response = getUpgrade("personal-loans/");

        int getStatusCode = response.getStatusCode();
        System.out.println("The response Status code is: "+getStatusCode);

        Assert.assertEquals(getStatusCode, 200);
    }

}
