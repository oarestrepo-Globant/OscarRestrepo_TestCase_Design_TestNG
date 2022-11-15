package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    @FindBy(id="global-viewport")
    private WebElement homePageView;
    @FindBy(id ="global-user-trigger")
    private WebElement userIcon;
    @FindBy(id ="oneid-iframe")
    private WebElement loginUserIFrame;
    @FindBy(id="logo")
    private WebElement espnLogo;
    @FindBy(css="button#BtnSubmit")
    private WebElement loginButton;
    @FindBy(css = "button#BtnCreateAccount")
    private WebElement signUpButton;
    @FindBy(css="li.user div.global-user-container ul.account-management li:last-child > a")
    private WebElement loginUserButton;
    @FindBy(css="input#InputLoginValue")
    private WebElement placeHolderUserName;
    @FindBy(css="input#InputPassword")
    private WebElement placeHolderPassword;
    @FindBy(css="li.user > div > div > ul.account-management > li.display-user > span")
    private WebElement userNameInNavText;

    @FindBy(css="li.pillar.watch > a")
    private WebElement watchButton;

    @FindBy(css="ul > li.user > div > div > ul.account-management > li:nth-child(9) > a")
    private WebElement logoutButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void placeMouseOnUserIcon(){
        super.placeMouseToElement(userIcon);
    }

    public void changeToLoginIframe(){
        super.changeToIframe(loginUserIFrame.getAttribute("id"));
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
    }

    public void clickLoginUserButton(){
        super.clickElement(loginUserButton);
    }

    public void enterLoginCredentials(String email, String password){
        super.typeOnPlaceholder(placeHolderUserName, email);
        super.typeOnPlaceholder(placeHolderPassword, password);
        super.clickElement(loginButton);
    }

    public String getUsernameLogged(){
        super.placeMouseToElement(userIcon);
        return userNameInNavText.getText();
    }

    public WatchPage clickWatchButton(){
        super.clickElement(watchButton);
        return new WatchPage(super.getDriver());
    }

    public void clickLogoutButton() throws InterruptedException {
        super.clickElement(logoutButton);

    }

    public boolean comprobarLogut(){
        return userNameInNavText.isDisplayed();
    }
}
