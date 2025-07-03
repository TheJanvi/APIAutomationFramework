package com.testingacademy.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.testingacademy.pojos.repsponse.BookingResponse;
import com.testingacademy.pojos.repsponse.TokenResponse;
import com.testingacademy.pojos.request.Auth;
import com.testingacademy.pojos.request.Booking;
import com.testingacademy.pojos.request.Bookingdates;

public class PayloadManager {
    Gson gson;
    Faker faker;

    //Convert the java object into the JSON String to use as payload.
    //Serialization
    public String createPayloadBookingAsString(){
        Booking booking = new Booking();
        booking.setFirstname("Jennie");
        booking.setLastname("Gia");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-02");
        bookingdates.setCheckout("2024-02-03");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("BreakFast");

        System.out.println(booking);

        //Java Object to Json

        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking;

    }
    //Convert the JSON String to a java object so that we can verify the response
    //De Serialization
    public BookingResponse bookingResponseJava(String responseString){
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;

    }

    //Java Object -> JSON
    public String setAuthPayload(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to the ->" + jsonPayloadString);
        return jsonPayloadString;
    }

    //DeSer (JSON String -> Java Object)

    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken();
    }
    public String createPayloadBookingAsStringWrongBody(){
        Booking booking = new Booking();
        booking.setFirstname("高血壓");
        booking.setLastname("高血壓");
        booking.setTotalprice(112);
        booking.setDepositpaid(false);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("5024-02-02");
        bookingdates.setCheckout("5024-02-03");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("高血壓");

        System.out.println(booking);

        //Java Object to Json

        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking;

    }
    public String createPayloadBookingAsStringFakerJS(){
        faker = new Faker();
        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1,1000));
        booking.setDepositpaid(faker.random().nextBoolean());

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("5024-02-02");
        bookingdates.setCheckout("5024-02-03");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        //Java Object to Json

        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking;

    }

    public Booking getResponseFromJSON(String getResponse) {
        gson = new Gson();
        Booking booking = gson.fromJson(getResponse, Booking.class);
        return booking;
    }

    public String fullUpdatePayloadAsString() {
        Booking booking = new Booking();
        booking.setFirstname("JANVI");
        booking.setLastname("Gogiya");
        booking.setTotalprice(2003);
        booking.setDepositpaid(false);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-03");
        bookingdates.setCheckout("2024-02-03");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("BreakFast");
        return gson.toJson(booking);
    }
}
