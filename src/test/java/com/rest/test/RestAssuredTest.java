package com.rest.test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class RestAssuredTest {
    public static Response response;
    public static String jsonAsString;

    @BeforeClass
    public static void setupURL() {
        // here we setup the default URL and API base path to use throughout the tests
        RestAssured.baseURI = "http://localhost:8081";
        RestAssured.basePath = "/entry-point/";
    }

    @Test
    public void checkEntryTest() {
        when().
                get("test").
                then().
                body(containsString("Test"));
    }

    @Test
    public void checkSum() {
        final String body = given().
                queryParam("a", 5).
                queryParam("b", 7).
                when().
                get("sum").getBody().asString();

        assertThat(body, equalTo("12.0"));
    }
}
