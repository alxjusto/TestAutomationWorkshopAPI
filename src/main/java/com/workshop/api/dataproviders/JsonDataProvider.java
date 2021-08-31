package com.workshop.api.dataproviders;

import com.google.gson.Gson;
import com.workshop.api.model.User;
import com.workshop.api.util.Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class JsonDataProvider {

    String capabilityFilePath = Utilities.getProperty("api.data.path") + "Usuarios.json";
    List<User> userList;

    public JsonDataProvider() throws FileNotFoundException {
        userList = getUsersList();
    }

    private List<User> getUsersList() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader bufferedReader = null;

        bufferedReader = new BufferedReader(new FileReader(capabilityFilePath));
        User[] users = gson.fromJson(bufferedReader, User[].class);

        return Arrays.asList(users);
    }

    public User getUser(String jobName) {
        return userList.stream().filter(user -> user.getJob().equalsIgnoreCase(jobName)).findAny().get();
    }
}
