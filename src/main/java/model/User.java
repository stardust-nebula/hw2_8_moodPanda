package model;

public class User {

    private String email = "073j5@mail2run.com";
    private String password = "123456789";

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
