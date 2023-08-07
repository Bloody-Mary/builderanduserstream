package ru.babushkina.userstreamapp._main;

import ru.babushkina.userstreamapp.mvc.controller.UserController;

public class _Main {
    public static void main(String[] args) {
        UserController controller = new UserController();
        controller.request1();
    }
}