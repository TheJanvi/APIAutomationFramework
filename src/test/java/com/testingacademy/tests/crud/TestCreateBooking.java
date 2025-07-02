package com.testingacademy.tests.crud;

import com.testingacademy.base.BaseTest;
import com.testingacademy.endpoints.APIConstants;
import com.testingacademy.pojos.repsponse.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import com.testingacademy.modules.PayloadManager;


public class TestCreateBooking extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @Owner("Jennie")
    @Description("TC#1 - Verify that Booking can be Created")
    public void testCreateBookingPOST_Positive() {

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingAsString()).post();
        System.out.println(response.asString());

        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());


        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Jennie");


    }
    @Test(groups = "reg", priority = 1)
    @Owner("Jennie")
    @Description("TC#1 - Verify that Booking can't be Created, when payload is Null")
    public void testCreateBookingPOST_Negative() {

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body("{}").post();
        System.out.println(response.asString());

       validatableResponse = response.then().log().all();
       validatableResponse.statusCode(500);

    }
    @Test(groups = "reg", priority = 1)
    @Owner("Jennie")
    @Description ("TC#1 - Verify that Booking can be created, when Payload is CHINESE")
    public void testCreateBookingPOST_Positive_CHINESE() {

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingAsStringWrongBody()).post();
        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }
    @Test(groups = "reg", priority = 1)
    @Owner("Jennie")
    @Description ("TC#1 - Verify that Booking can be created, when Payload is RANDOM")
    public void testCreateBookingPOST_Positive_RANDOM_DATA() {

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingAsStringFakerJS()).post();
        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }



}
