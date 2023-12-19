package com.qacart.todo.api;

import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

import static com.qacart.todo.constants.EndPoints.REGISTER_API;
import static io.restassured.RestAssured.given;

public class RegisterAPI {


    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userId;
    private String firstName;


    public String getFirstName() {
        return firstName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public List<Cookie> getRestAssuredCookies() {
        return restAssuredCookies;
    }

    public void register() {

        User user = UserUtils.generateRandomUser();

        Response response =
                given()
                    .baseUri("http://qacart-todo.herokuapp.com/")
                    .header("Content-Type", "application/json")
                    .body(user)
                    .log().all()
                .when()
                    .post(REGISTER_API)
                .then()
                    .log().all()
                    .extract().response();

        if(response.statusCode() != 201){
            throw new RuntimeException("Something went wrong");
        }
        restAssuredCookies = response.detailedCookies().asList();
        accessToken = response.path("access_token");
        userId = response.path("userID");
        firstName = response.path("firstName");


    }
}
