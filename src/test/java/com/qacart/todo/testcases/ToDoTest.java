package com.qacart.todo.testcases;

import com.qacart.todo.api.AddNewToDoAPI;
import com.qacart.todo.api.RegisterAPI;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewToDoPage;
import com.qacart.todo.pages.ToDoPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Todo Feature")

public class ToDoTest extends BaseTest {


    @Story("Add Todo")
    @Test(description = "Should be able to add new to do correctly")
    public void shouldBeAbleToAddNewToDo(){

        RegisterAPI registerAPI = new RegisterAPI();
        registerAPI.register();

        ToDoPage toDoPage = new ToDoPage(getDriver());
        toDoPage.load();
        injectCookiesToBrowser(registerAPI.getRestAssuredCookies());

        String todoText = "to do";

        String newAddedToDoText = toDoPage
                .load()
                .clickOnAddNewToDoButton()
                .addNewToDo(todoText)
                .getNewAddedToDoText();

        Assert.assertEquals(newAddedToDoText, todoText);
    }

    @Story("Delete Todo")
    @Test(description = "Should be able to delete todo correctly")
    public void shouldBeAbleToDeleteToDo(){
        String todoText = "to do";

        RegisterAPI registerAPI = new RegisterAPI();
        registerAPI.register();

        AddNewToDoAPI addNewToDoAPI = new AddNewToDoAPI();
        addNewToDoAPI.addNewToTo(todoText, registerAPI.getAccessToken());


        ToDoPage toDoPage = new ToDoPage(getDriver());
        toDoPage.load();
        injectCookiesToBrowser(registerAPI.getRestAssuredCookies());



        boolean isNoToDosPlaceholderTextIsDisplayed = toDoPage
                .load()
                .clickOnDeleteToDoButton()
                .isNoToDosPlaceholderTextIsDisplayed();
        Assert.assertTrue(isNoToDosPlaceholderTextIsDisplayed);
    }



}
