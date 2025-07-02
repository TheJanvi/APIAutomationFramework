package com.testingacademy.tests.crud;


import com.testingacademy.base.BaseTest;
import com.testingacademy.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateToken extends BaseTest {


    @Test(groups = "reg", priority = 1)
    @TmsLink("https://bugz.atlassin.net/browser/TS-1")
    @Owner("Jennie")
    @Description("TC#2 - Create Token and Verify")
    public void testTokenPOST(){
        //Prep of req
        requestSpecification.basePath(APIConstants.AUTH_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.setAuthPayload()).post();
        //Extraction
        String token = payloadManager.getTokenFromJSON(response.asString());
        System.out.println(token);
        //Validation of the request.
        assertActions.verifyStringKeyNotNull(token);
    }
}
