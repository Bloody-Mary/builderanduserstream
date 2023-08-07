package ru.babushkina.userstreamapp.mvc.controller;

import ru.babushkina.userstreamapp.mvc.model.entity.User;
import ru.babushkina.userstreamapp.mvc.view.UserView;
import ru.babushkina.userstreamapp.mvc.model.service.UserService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserController {
    private final UserService userService;
    private final UserView view;

    public UserController() {
        this.userService = new UserService();
        this.view = new UserView();
    }

    public void request1() {
        Stream<User> userStream = userService.generateUserStream(20);
        Stream<User> streamResult = processUserStream(userStream);
        List<User> sortedUsers = processSortedUsers(streamResult);
        view.displaySortedUsers(sortedUsers);

        boolean hasUserWithMatchingAge = checkMatchingAge();
        view.displayMatchingAge(hasUserWithMatchingAge);
    }

    private Stream<User> processUserStream(Stream<User> userStream) {
        return userStream;
    }

    private List<User> processSortedUsers(Stream<User> userStream) {
        return userStream
                .sorted((u1, u2) -> Integer.compare(u2.getAge(), u1.getAge()))
                .collect(Collectors.toList());
    }

    private boolean checkMatchingAge() {
        UserService userService = new UserService();
        Stream<User> userStream = userService.generateUserStream(20);

        return userStream.anyMatch(user -> user.getAge() == user.getId());
    }
}