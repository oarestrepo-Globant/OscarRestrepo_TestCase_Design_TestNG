package org.espn.tests;

import org.espn.pages.WatchPage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest{
   private final String userName = "Oscar!";

    @Test(dataProvider = "credentialsToLogin")
    public void doingLogin(String email, String password){
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
       checkThat("'X' button to close is present on the second card in the first carousel", watchPage.isXButtonFromSupplierModalPresent(), is(true));
       watchPage.clickXButtonFromSupplierModal();
       watchPage.backToHomePage();
       checkThat("'Nav text' has 'Welcome {{username}}!'", home.getUsernameLogged(), is(userName));
       home.clickLogoutButton();

       checkThat("Welcome message has no username specified", home.getListOfUserNameInNavText(), is(false));
    }

   /*@Test
   public void watchPage(){

    }*/
}
