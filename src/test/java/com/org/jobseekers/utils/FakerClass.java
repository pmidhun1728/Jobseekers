package com.org.jobseekers.utils;

import com.github.javafaker.Faker;

public class FakerClass {

    private static final Faker faker = new Faker();

    public static String getEmail(){
        return faker.internet().emailAddress();
    }

}
