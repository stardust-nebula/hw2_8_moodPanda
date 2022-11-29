package service;

import model.User;
import page.GlobalPage;
import page.LoginPage;

public class LoginPageService {

    private static final String LOGIN_URL = "https://moodpanda.com/login";
    private LoginPage loginPage = new LoginPage();

    public GlobalPage login(User user){
        loginPage
                .openPage(LOGIN_URL)
                .enterEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .clickLoginButton();
        return new GlobalPage();
    }

}
