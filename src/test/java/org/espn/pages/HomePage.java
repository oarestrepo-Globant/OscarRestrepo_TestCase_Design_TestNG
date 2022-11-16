package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(css="li.user > div > div > ul.account-management > li.display-user > span")
    private List<WebElement> userNameInNavTextList;

    @FindBy(css="li.pillar.watch > a")
    private WebElement watchButton;

    @FindBy(css="ul > li.user > div > div > ul.account-management > li:nth-child(9) > a")
    private WebElement logoutButton;

    @FindBy(css = ".display-user span")
    private WebElement userText;

    @FindBy(css="ul .account-management >li > a[tref='/members/v3_1/modifyAccount']")
    private WebElement espnProfileButton;

    @FindBy(css="a[id='AccountDeleteLink']")
    private WebElement deleteAccountTextButton;

    @FindBy(css="button#BtnSubmit")
    private WebElement yesDeleteAccountButton;

    @FindBy(id="#BtnSubmit")
    private WebElement okButtonFromDeleteAccount;

    @FindBy(xpath="html/body/div[4]/iframe")
    //".promo-banner-container iframe"
    //
    private WebElement iframeBanner;

    @FindBy(css ="div.PromoBanner__CloseBtn")
    private WebElement closeButtonPromoBannerContainer;

    @FindBy(className="promo-banner-container")
    private WebElement promoBannerContainer;

    @FindBy(css="div .form-section")
    private WebElement form;

    @FindBy(css=".form-section > #BtnSubmit")
    private WebElement submitButtonFromLoginAndLogutIframe;

    @FindBy(css="#Title > span")
    private WebElement areYouSureText;

    @FindBy(css="#OtpInputLoginValue-error > a")
    private WebElement createAccountTextInFindYourAccount;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void placeMouseOnUserIcon(){
        super.placeMouseToElement(userIcon);
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

    public void changeToLoginIframe(){
        super.changeToIframe(loginUserIFrame.getAttribute("id"));
    }

    public void clickLoginUserButton(){
        //changeToLoginIframe();
        super.clickElement(loginUserButton);
    }

    public void enterLoginCredentials(String email, String password){
        super.typeOnPlaceholder(placeHolderUserName, email);
        super.typeOnPlaceholder(placeHolderPassword, password);
        super.clickElement(loginButton);
        //getDriver().switchTo().defaultContent();
    }

    public String getUsernameLogged() {
        super.placeMouseToElement(userIcon);
        return userNameInNavText.getText();
    }

    public WatchPage clickWatchButton(){
        super.clickElement(watchButton);
        return new WatchPage(super.getDriver());
    }

    public void clickLogoutButton() {
        super.clickElement(logoutButton);
    }

    //CAMBIAR NOMBRE
    public boolean checkUserIsLoggedOut() {
        super.refreshBrowser();
        super.placeMouseToElement(userIcon);
        return userNameInNavTextList.size() == 0;
    }

    public boolean login(String email, String password) {
        placeMouseOnUserIcon();
        //incluir el change iframe dentro del clicklogin y probar
        clickLoginUserButton();
        changeToLoginIframe();
       enterLoginCredentials(email, password);
       return true;
        //clickLoginUserButton();
    }

    public void logout(){
        placeMouseOnUserIcon();
        clickLogoutButton();
        checkUserIsLoggedOut();
    }

    public void changeToBannerIframe(){
        super.changeToIframe(iframeBanner.getAttribute("src"));
    }

    public void waitForAreYouSureText(){
        super.waitForVisibility(areYouSureText);
    }

    public void deactivate()  {
        placeMouseOnUserIcon();
        super.clickElement(espnProfileButton);
        changeToLoginIframe();
        super.waitForVisibility(deleteAccountTextButton);

        //Scroll form
        super.scrollDownPage(form);
        super.placeMouseToElement(deleteAccountTextButton);
        super.clickElement(deleteAccountTextButton);

        waitForAreYouSureText();
        super.waitForText(submitButtonFromLoginAndLogutIframe, "Yes, delete this account");
        super.clickElement(submitButtonFromLoginAndLogutIframe);
        super.waitForText(submitButtonFromLoginAndLogutIframe,"OK" );
        super.clickElement(submitButtonFromLoginAndLogutIframe);

        //verificar que el iframe tenga titulo Find Your Account
        super.waitForText(areYouSureText, "Account Deactivated");
    }
    public boolean isAccountDeactivated(){
        return submitButtonFromLoginAndLogutIframe.isDisplayed();
    }
    public void confirm(){
        super.waitForText(areYouSureText, "Find Your Account");
        super.waitForText(areYouSureText, "Account Deactivated");
    }
   /* public boolean isPromoBannerContainerDisplayed(){
        promoBannerContainer.isDisplayed();
        return false;
    }
    public void closeBannerContainer(){
        clickElement(closeButtonPromoBannerContainer);;
    }*/
}
