package com.qacart.todo.api;

import com.qacart.todo.objects.Task;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AddNewToDoAPI {


    public void addNewToTo(String toDoContent,String token) {

        Task body = new Task(toDoContent,false);

        Response response =
                given()
                        .baseUri("http://qacart-todo.herokuapp.com/")
                        .header("Content-Type", "application/json")
                        .body(body)
                        .auth().oauth2(token)
                        .log().all()
                        .when()
                        .post("api/v1/tasks")
                        .then()
                        .log().all()
                        .extract().response();

        if(response.statusCode() != 201){
            throw new RuntimeException("Something went wrong in adding todo");
        }

    }
}
