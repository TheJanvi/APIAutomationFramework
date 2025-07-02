package com.testingacademy.asserts;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class AssertActions {


    public void verifyResponseBody(String actual, String expected, String Description){
        assertEquals(actual, expected, Description);
    }
    public void verifyResponseBody(int actual, int expected, String Description){
        assertEquals(actual, expected, Description);
    }

    public void verifyStatusCode(Response response, Integer expected ){
        assertEquals(response.getStatusCode(), expected);
    }

    //Assertj
    public void verifyStringKey(String keyExpect, String keyActual){

        assertThat(keyExpect).isNotNull();
        assertThat(keyExpect).isNotBlank();
        assertThat(keyExpect).isEqualTo(keyActual);
    }

    public void verifyStringKeyNotNull(Integer keyExpect){
        assertThat(keyExpect).isNotNull();
    }

    public void verifyStringKeyNotNull(String keyExpect){
        assertThat(keyExpect).isNotNull();
    }





}
