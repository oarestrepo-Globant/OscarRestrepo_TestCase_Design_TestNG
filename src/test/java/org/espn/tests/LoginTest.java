package org.espn.tests;

import org.espn.pages.BasePage;
import org.espn.pages.LoginPage;
import org.espn.pages.UserPage;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class LoginTest extends BaseTest{
    @Test
    public void login(){
        // Estoy instanciando una pagina home.
        BasePage home = new BasePage(driver.getDriver());
        // vaya al userIcon y ponga el mouse sobre el
        home.placeMouseOnUserIcon();

        //      SE ABRE UNA NUEVA PAGINA      //
        // Instanciar userPage
        UserPage userPage = new UserPage(driver.getDriver());
        // Click en login button
        userPage.clickLoginUserButton();

        //      SE ABRE iFrame Login      //
        // Instanciar nueva pagina
        LoginPage loginPage = new LoginPage(driver.getDriver());

        checkThat("Modal is present",loginPage.isModalLoginDisplayed(), is(true));


        // SWITCH IFRAME LOGIN //
        loginPage.changeToLoginIframe();
        //loginPage.isEspnLogoDisplayed();
        checkThat("ESPN Logo is present",loginPage.isEspnLogoDisplayed(), is(true));
        checkThat("Signup button is present",loginPage.isSignUpButtonDisplayed(), is(true));
        checkThat("Login button is present", loginPage.checkLoginIsDisplayed(), is(true));




    }
}
