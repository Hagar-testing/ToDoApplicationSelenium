package com.qacart.todo.api;

import com.qacart.todo.objects.User;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import java.util.List;

import static com.qacart.todo.constants.ApiPathsConstants.REGISTER_API;
import static com.qacart.todo.constants.ApiResponseConstants.*;
import static io.restassured.RestAssured.given;

public class RegisterAPI {


    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userId;
    private String firstName;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

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
                    .baseUri(ConfigUtils.getBaseUrl())
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
        accessToken = response.path(ACCESS_TOKEN);
        userId = response.path(USER_ID);
        firstName = response.path(FIRST_NAME);
        email = user.getEmail();
        password = user.getPassword();


    }
}
