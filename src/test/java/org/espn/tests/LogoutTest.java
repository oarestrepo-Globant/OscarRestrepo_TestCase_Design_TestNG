package org.espn.tests;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class LogoutTest extends BaseTest {
    @Test(dataProvider = "credentialsToLogin")
    public void doingLogout(String email, String password){
        home.login(email, password);
        home.logout();
        checkThat("Welcome message has no username specified", home.checkUserIsLoggedOut(), is(true));
    }
}
