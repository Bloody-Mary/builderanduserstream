package ru.babushkina.userstreamapp._main;

import ru.babushkina.userstreamapp.mvc.model.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _Main {
    public static void main(String[] args) {
        List<User> users = generateRandomUsers(20);
        startUserThreads(users);

        Stream<User> userStream = users.stream();

        List<User> sortedUsers = userStream
                .sorted((u1, u2) -> Integer.compare(u2.getAge(), u1.getAge()))
                .collect(Collectors.toList());

        System.out.println("Отсортированные пользователи:");
        for (User user : sortedUsers) {
            System.out.println(user);
        }

        boolean hasUserWithMatchingAge = users.stream()
                .anyMatch(user -> user.getAge() == user.getId());

        System.out.println("Есть ли пользователи, у которых возраст совпадает с id: " + hasUserWithMatchingAge);
    }

    private static List<User> generateRandomUsers(int count) {
        List<User> users = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int id = random.nextInt(1000) + 1;
            String login = String.valueOf(generateRandomString(random.nextInt(16) + 5));
            StringBuilder password = generateRandomString(random.nextInt(16) + 5);
            int age = random.nextInt(50) + 18;

            User user = new User.Builder()
                    .setId((long) id)
                    .setLogin(login)
                    .setPassword(password)
                    .setAge(age)
                    .build();

            users.add(user);
        }

        return users;
    }

    private static void startUserThreads(List<User> users) {
        for (User user : users) {
            Thread thread = new Thread(() -> {
                System.out.println("Поток пользователя " + user.getId() + " запустился.");
            });
            thread.start();
        }
    }

    private static StringBuilder generateRandomString(int length) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char randomChar = (char) (Math.random() * 26 + 'a');
            stringBuilder.append(randomChar);
        }

        return stringBuilder;
    }
}