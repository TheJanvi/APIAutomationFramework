package com.testingacademy.base;

import com.testingacademy.asserts.AssertActions;
import com.testingacademy.endpoints.APIConstants;
import com.testingacademy.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    //common to all testcase
    //Base URL, Content Type - json - common
    public PayloadManager payloadManager;
    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public AssertActions assertActions;
    public JsonPath jsonPath;

    @BeforeTest
    public void setup(){
        System.out.println("Starting the test!");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

//        requestSpecification = RestAssured.given();
//        requestSpecification.baseUri(APIConstants.BASE_URL);
//        requestSpecification.contentType(ContentType.JSON).log().all();

          requestSpecification = new RequestSpecBuilder()
                  .setBaseUri(APIConstants.BASE_URL)
                  .addHeader("Content-Type", "application/json")
                  .build().log().all();




    }

    @AfterTest
    public void teardown(){
        System.out.println("Finished the test!");

    }













}

