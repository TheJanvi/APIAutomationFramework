package com.testingacademy.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {

    //Create a Booking, Create a token
    //Verify that get booking
    //Update the Booking
    //Delete the Booking

    @Test (groups = "QA", priority = 1)
    @Owner("Jennie")
    @Description ("TC#INT1 = Step 1. Verify that Booking can be created")

    public void testCreateBooking(){
        Assert.assertTrue(true);
    }

    @Test (groups = "QA", priority = 2)
    @Owner("Jennie")
    @Description ("TC#INT1 = Step 2. Verify that Booking by ID")

    public void testVerifyBooking(){
        Assert.assertTrue(true);
    }

    @Test (groups = "QA", priority = 3)
    @Owner("Jennie")
    @Description ("TC#INT1 = Step 3. Verify Update Booking by ID")

    public void testUpdateBooking(){
        Assert.assertTrue(true);
    }

    @Test (groups = "QA", priority = 4)
    @Owner("Jennie")
    @Description ("TC#INT1 = Step 4. Delete that booking by ID")

    public void testDeleteBooking(){
        Assert.assertTrue(true);
    }
}
