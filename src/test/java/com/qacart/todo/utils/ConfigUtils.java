package com.qacart.todo.utils;

import java.util.Properties;

import static com.qacart.todo.constants.ConfigConstants.BASE_URL;

public class ConfigUtils {

    private static final Properties properties;

    static {
        properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/stg.properties");
    }


    public static String getBaseUrl(){
        String urlFromSys = System.getProperty(BASE_URL);
        return urlFromSys != null ? urlFromSys : properties.getProperty(BASE_URL);
    }
}
