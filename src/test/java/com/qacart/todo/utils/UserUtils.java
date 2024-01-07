package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.objects.User;

public class UserUtils {

    public static User generateRandomUser() {

        Faker faker = new Faker();

        // Generate fake user data
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userPassword = faker.internet().password();

        return new User(
                firstName,
                lastName,
                userEmail,
                userPassword);
    }
}
