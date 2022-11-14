package org.espn.tests;

import org.espn.pages.HomePage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest{
    private final String userName = "Oscar!";

    @Test(dataProvider = "credentialsToLogin")
    public void login(String email, String password){
        HomePage home = new HomePage(driver.getDriver());
        home.placeMouseOnUserIcon();
        home.clickLoginUserButton();
        checkThat("Modal is present",home.isModalLoginDisplayed(), is(true));
        home.changeToLoginIframe();
        checkThat("ESPN Logo is present",home.isEspnLogoDisplayed(), is(true));
        checkThat("Signup button is present",home.isSignUpButtonDisplayed(), is(true));
        checkThat("Login button is present", home.checkLoginIsDisplayed(), is(true));
        home.enterLoginCredentials(email, password);
        checkThat("Succes login", home.getUsernameLogged(), is(userName));
        home.clickWatchButton();
    }

   /* @Test
    public void watchPage(){

    }*/
}
