package org.espn.tests;

import org.espn.pages.WatchPage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest{
    private final String userName = "Oscar!";

    @Test(dataProvider = "credentialsToLogin")
    public void login(String email, String password) throws InterruptedException {
        home.placeMouseOnUserIcon();
        home.clickLoginUserButton();
        checkThat("Modal is present",home.isModalLoginDisplayed(), is(true));
        home.changeToLoginIframe();
        checkThat("ESPN Logo is present",home.isEspnLogoDisplayed(), is(true));
        checkThat("Signup button is present",home.isSignUpButtonDisplayed(), is(true));
        checkThat("Login button is present", home.checkLoginIsDisplayed(), is(true));
        home.enterLoginCredentials(email, password);
        checkThat("Succes login", home.getUsernameLogged(), is(userName));
        WatchPage watchPage = home.clickWatchButton();

        // watch //
       checkThat("At least one carousel is present in watchPage", watchPage.isCarouselContainerAndContainersDisplayed(), is(true));
       checkThat("'X' button to close is present", watchPage.isXButtonFromSupplierModalPresent(), is(true));
       watchPage.clickXButtonFromSupplierModal();
       watchPage.backToHomePage();
       checkThat("'Nav text' has 'Welcome {{username}}!'", home.getUsernameLogged(), is(true));
       home.clickLogoutButton();
       checkThat("the element 'Nav text' has text: 'Welcome!' without user name specified", home.comprobarLogut(), is(false));

    }

   /* @Test
    public void watchPage(){

    }*/
}
