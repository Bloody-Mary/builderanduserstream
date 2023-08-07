package ru.babushkina.userstreamapp.mvc.model.service;
































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
