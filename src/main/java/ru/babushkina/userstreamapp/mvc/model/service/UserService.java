package ru.babushkina.userstreamapp.mvc.model.service;

import ru.babushkina.userstreamapp.mvc.model.entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserService {
    public Stream<User> generateEmptyUsers (int count) {
        List<User> emptyUsers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            emptyUsers.add(new User(null, "", new StringBuilder(), 0));
        }
        return emptyUsers.stream();
    }

    public Stream<User> initializedUsers (Stream<User> userStream) {
        return userStream.map(user -> new User.Builder()
                .setLogin(generateRandomString(5, 20))
                .setPassword(new StringBuilder(generateRandomString(5, 20)))
                .setAge(new Random().nextInt(50))
                .build());
    }

    public String generateRandomString(int minLength, int maxLength) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public List<User> processSortedUsers(Stream<User> userStream) {
        return userStream
                .sorted((u1, u2) -> Integer.compare(u2.getAge(), u1.getAge()))
                .collect(Collectors.toList());
    }

    public boolean checkMatchingAge(Stream<User> userStream) {
        return userStream.anyMatch(user -> user.getAge() == user.getId());
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
