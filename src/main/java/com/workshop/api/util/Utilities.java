package com.workshop.api.util;

import java.util.ResourceBundle;

public class Utilities {

    private final static String FILE_CONFIGURATION_PROPERTIES = "Configuration";

    public static String getProperty(String key) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(FILE_CONFIGURATION_PROPERTIES);
        return resourceBundle.getString(key);
    }
}
