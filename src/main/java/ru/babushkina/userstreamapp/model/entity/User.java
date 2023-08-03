package ru.babushkina.userstreamapp.model.entity;

public class User {
    private Long id;
    private String login;
    private StringBuilder password;
    private int age;

    private User (Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.age = builder.age;
    }

    public static class Builder {
        private Long id;
        private String login;
        private StringBuilder password;
        private int age;

        public Builder() {
            this.password = new StringBuilder();
        }

        public Builder setId (Long id) {
            this.id = id;
            return this;
        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public StringBuilder getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }
}
