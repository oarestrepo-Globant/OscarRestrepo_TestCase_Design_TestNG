package org.espn.tests;

import org.espn.pages.HomePage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest{
    private final String userName = "Oscar!";
    @Test
    public void login(){
        HomePage home = new HomePage(driver.getDriver());
        home.placeMouseOnUserIcon();
        home.clickLoginUserButton();
        checkThat("Modal is present",home.isModalLoginDisplayed(), is(true));
        // SWITCH IFRAME LOGIN //
        home.changeToLoginIframe();
        checkThat("ESPN Logo is present",home.isEspnLogoDisplayed(), is(true));
        checkThat("Signup button is present",home.isSignUpButtonDisplayed(), is(true));
        checkThat("Login button is present", home.checkLoginIsDisplayed(), is(true));

        //LOGUEARME
        home.enterLoginCredentials();
        checkThat("Succes login", home.getUsernameLogged(), is(userName));
        home.clickWatchButton();
    }
}
