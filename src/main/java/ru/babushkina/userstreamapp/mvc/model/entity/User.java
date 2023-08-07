package ru.babushkina.userstreamapp.mvc.model.entity;

public class User {
    Long id;
    private String login;
    private StringBuilder password;
    private int age;

    public User(Long id, String login, StringBuilder password, int age) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public StringBuilder getPassword() {
        return password;
    }

    public void setPassword(StringBuilder password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class Builder {
        Long id;
        private String login;
        private StringBuilder password;
        private int age;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setPassword(StringBuilder password) {
            this.password = password;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(id, login, password, age);
        }
    }

    @Override
    public String toString() {
        return "Пользователь: " +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age;
    }
}





























//public class User {
//    private Long id;
//    private String login;
//    private StringBuilder password;
//    private int age;
//
//    private User (Builder builder) {
//        this.id = builder.id;
//        this.login = builder.login;
//        this.password = builder.password;
//        this.age = builder.age;
//    }
//
//    public static class Builder {
//        private Long id;
//        private String login;
//        private StringBuilder password;
//        private int age;
//
//        public Builder id(Long id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder login(String login) {
//            this.login = login;
//            return this;
//        }
//
//        public Builder password(StringBuilder password) {
//            this.password = password;
//            return this;
//        }
//
//        public Builder age(int age) {
//            this.age = age;
//            return this;
//        }
//
//        public User build() {
//            return new User(this);
//        }
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public StringBuilder getPassword() {
//        return password;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    @Override
//    public String toString() {
//        return "User" +
//                "id = " + id +
//                ", login = " + login +
//                ", password = " + password.toString() +
//                ", age = " + age;
//    }
//}
