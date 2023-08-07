package ru.babushkina.userstreamapp.mvc.view;

import ru.babushkina.userstreamapp.mvc.model.entity.User;

import java.util.List;

public class UserView {
    public void displaySortedUsers(List<User> sortedUsers) {
        System.out.println("Отсортированные пользователи:");
        for (User user : sortedUsers) {
            System.out.println(user);
        }
    }

    public void displayMatchingAge(boolean hasMatchingAge) {
        System.out.println("Есть ли пользователи с возрастом, совпадающим с их id: " + hasMatchingAge);
    }
}