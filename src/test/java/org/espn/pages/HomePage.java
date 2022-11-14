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
    @FindBy(css=" li.user > div > div > ul.account-management > li.display-user > span")
    private WebElement userNameInNavText;
    @FindBy(css="a[href='http://www.espn.com/watch/'] > span > span.link-text")
    private WebElement watchButton;

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

    public void enterLoginCredentials(){
        super.typeOnPlaceholder(placeHolderUserName, "pruebita@hotmail.com");
        super.typeOnPlaceholder(placeHolderPassword, "prueba123");
        super.clickElement(loginButton);
    }

    public String getUsernameLogged(){
        super.placeMouseToElement(userIcon);
        return userNameInNavText.getText();
    }

    public void clickWatchButton(){
        super.clickElement(watchButton);
        new WatchPage(getDriver());
    }
}
