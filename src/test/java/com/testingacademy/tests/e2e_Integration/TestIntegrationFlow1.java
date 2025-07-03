package com.testingacademy.tests.e2e_Integration;

import com.testingacademy.base.BaseTest;
import com.testingacademy.endpoints.APIConstants;
import com.testingacademy.pojos.repsponse.BookingResponse;
import com.testingacademy.pojos.request.Booking;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestIntegrationFlow1  extends BaseTest {
    @Test(groups = "QA", priority = 1)
    @Owner("Jennie")
    @Description("TC#INT1 = Step 1. Verify that Booking can be created")

    public void testCreateBooking(ITestContext iTestContext){
       requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
       response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingAsString()).post();
       validatableResponse = response.then().log().all();
       validatableResponse.statusCode(200);

        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Jennie");
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());

        iTestContext.setAttribute("bookingid",bookingResponse.getBookingid());

    }

    @Test (groups = "QA", priority = 2)
    @Owner("Jennie")
    @Description ("TC#INT1 = Step 2. Verify that Booking by ID")

    public void testVerifyBooking(ITestContext iTestContext) {
            Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

            String basePathGET = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathGET);

        requestSpecification.basePath(basePathGET);
        response = RestAssured.given(requestSpecification).when().get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        Booking booking= payloadManager.getResponseFromJSON(response.asString());
        assertActions.verifyStringKeyNotNull(booking.getFirstname());
    }

    @Test (groups = "QA", priority = 3)
    @Owner("Jennie")
    @Description ("TC#INT1 = Step 3. Verify Update Booking by ID")

    public void testUpdateBooking(ITestContext iTestContext){
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String token = getToken();
        iTestContext.setAttribute("token", token);

        String basePathPUTPATCH = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathPUTPATCH);

        requestSpecification.basePath(basePathPUTPATCH);

        response = RestAssured
                .given(requestSpecification).cookie("token", token)
                .when().body(payloadManager.fullUpdatePayloadAsString()).put();

        validatableResponse = response.then().log().all();
        //validate Assertion
        validatableResponse.statusCode(200);

        Booking booking = payloadManager.getResponseFromJSON(response.asString());
        assertActions.verifyStringKeyNotNull(booking.getFirstname());
       assertActions.verifyStringKey(booking.getFirstname(),"JANVI");

    }

    @Test (groups = "QA", priority = 4)
    @Owner("Jennie")
    @Description ("TC#INT1 = Step 4. Delete that booking by ID")

    public void testDeleteBooking(ITestContext iTestContext){
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String token = (String) iTestContext.getAttribute("token");
        if (token.equalsIgnoreCase(null)){
            token = getToken();
        }
        String basePathDELETE = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathDELETE);

        requestSpecification.basePath(basePathDELETE).cookie("token", token);
        validatableResponse = RestAssured.given().spec(requestSpecification).when().delete().then().log().all();
        validatableResponse.statusCode(201);



    }
}
