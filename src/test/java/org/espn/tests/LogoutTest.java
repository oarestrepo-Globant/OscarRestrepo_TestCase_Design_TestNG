package org.espn.tests;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class LogoutTest extends BaseTest {
    @Test(dataProvider = "credentialsToLogin")
    public void doingLogout(String email, String password){
        //HomePage home = new HomePage(driver.getDriver());
        home.login(email, password);
        home.logout();
        checkThat("Welcome message has no username specified", home.getListOfUserNameInNavText(), is(false));    }
}
