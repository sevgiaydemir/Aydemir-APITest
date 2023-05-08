package com.testData.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hook {
    @Before
    public void setUp(){
        RestAssured.baseURI="https://randomuser.me";
        RestAssured.basePath="/api/";
    }

}
