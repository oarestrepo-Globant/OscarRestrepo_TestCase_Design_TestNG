package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id ="oneid-iframe")
    private WebElement loginUserIFrame;
    @FindBy(id="logo")
    private WebElement espnLogo;
    @FindBy(css="button#BtnSubmit")
    private WebElement loginButton;
    @FindBy(css = "button#BtnCreateAccount")
    private WebElement signUpButton;

    public void changeToLoginIframe(){
        changeToIframe(loginUserIFrame.getAttribute("id"));
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public boolean isModalLoginDisplayed(){
        return loginUserIFrame.isDisplayed();
    }

    public boolean isEspnLogoDisplayed(){
        return espnLogo.isDisplayed();
    }

    public boolean isSignUpButtonDisplayed(){
        return signUpButton.isDisplayed();
    }

    public boolean checkLoginIsDisplayed(){
        return loginButton.isDisplayed();
    };
}
