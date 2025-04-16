package com.org.jobseekers.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static final Properties properties;

    static{

        try{
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/application.properties");
           properties = new Properties();
            properties.load(fileInputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
