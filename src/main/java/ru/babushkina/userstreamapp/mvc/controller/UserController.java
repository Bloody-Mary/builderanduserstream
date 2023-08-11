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
        Stream<User> userEmptyStream = userService.generateEmptyUsers(20);
        Stream<User> userStream = userService.initializedUsers(userEmptyStream);
        List<User> userStreamList = userStream.collect(Collectors.toList());
        List<User> sortedUsers = userService.processSortedUsers(userStreamList.stream());
        view.displaySortedUsers(sortedUsers);
        boolean hasUserWithMatchingAge = userService.checkMatchingAge(sortedUsers.stream());
        view.displayMatchingAge(hasUserWithMatchingAge);
    }
}