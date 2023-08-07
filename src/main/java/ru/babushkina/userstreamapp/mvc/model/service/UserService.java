package ru.babushkina.userstreamapp.mvc.model.service;

import ru.babushkina.userstreamapp.mvc.model.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class UserService {
    public Stream<User> generateUserStream(int count) {
        List<User> users = generateRandomUsers(count);
        return users.stream();
    }

    private List<User> generateRandomUsers(int count) {
        List<User> users = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            Long id = (long) (random.nextInt(100) + 1);
            String login = generateRandomString(random.nextInt(16) + 5);
            StringBuilder password = new StringBuilder(generateRandomString(random.nextInt(16) + 5));
            int age = random.nextInt(50) + 18;

            User user = new User(id, login, password, age);
            users.add(user);
        }

        return users;
    }

    private String generateRandomString(int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}






























//public class UserService {
//    public Stream<User> generateEmptyUsers(int count) {
//        List<User> users = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            users.add(new User(null, "", new StringBuilder(), 0));
//        }
//        return users.stream();
//    }
//
//    public List<User> sortUsers(Stream<User> userStream) {
//        List<User> sortedUsers = userStream
//                .sorted((u1, u2) -> Integer.compare(u2.getAge(), u1.getAge())) // Сортировка пользователей по убыванию возраста
//                .collect(Collectors.toList()); // Сохранение отсортированных пользователей в коллекцию
//        return sortedUsers;
//    }
//
//    public boolean checkUserMatchingAge(List<User> users) {
//        return users.stream()
//                .anyMatch(user -> user.getAge() == user.getId()); // Проверка, есть ли пользователь с возрастом, совпадающим с его id
//    }
//}
