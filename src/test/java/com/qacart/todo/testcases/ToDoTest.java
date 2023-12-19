package com.qacart.todo.testcases;

import com.qacart.todo.api.AddNewToDoAPI;
import com.qacart.todo.api.RegisterAPI;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.NewToDoPage;
import com.qacart.todo.pages.ToDoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToDoTest extends BaseTest {


    @Test
    public void shouldBeAbleToAddNewToDo(){

        RegisterAPI registerAPI = new RegisterAPI();
        registerAPI.register();

        ToDoPage toDoPage = new ToDoPage(driver);
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

    @Test
    public void shouldBeAbleToDeleteToDo(){
        String todoText = "to do";

        RegisterAPI registerAPI = new RegisterAPI();
        registerAPI.register();

        AddNewToDoAPI addNewToDoAPI = new AddNewToDoAPI();
        addNewToDoAPI.addNewToTo(todoText, registerAPI.getAccessToken());


        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.load();
        injectCookiesToBrowser(registerAPI.getRestAssuredCookies());



        boolean isNoToDosPlaceholderTextIsDisplayed = toDoPage
                .load()
                .clickOnDeleteToDoButton()
                .isNoToDosPlaceholderTextIsDisplayed();
        Assert.assertTrue(isNoToDosPlaceholderTextIsDisplayed);
    }



}
