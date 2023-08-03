package ru.babushkina.userstreamapp._main;

import ru.babushkina.userstreamapp.model.entity.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int randomSize = (int) (Math.random() * 16) + 5;
            User user = new User.Builder()
                    .setId((long) (Math.random() * 1000))
                    .setLogin(generateRandomString(randomSize))
                    .setPassword(generateRandomString(randomSize))
                    .setAge((int) (Math.random() * 100))
                    .build();
            users.add(user);
        }

        boolean hasMatchingUser = users.stream()
                .anyMatch(user -> user.getId().equals((long) user.getAge()));

        System.out.println("Есть пользователь с возрастом, совпадающим с его id: " + hasMatchingUser);
    }


        public static String generateRandomString(int length) {
            String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuilder randomString = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int index = (int) (Math.random() * chars.length());
                randomString.append(chars.charAt(index));
            }

            return randomString.toString();
        }


    }
