package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage {
    @FindBy(css="li.user div.global-user-container ul.account-management li:last-child > a")
    private WebElement loginUserButton;

    public UserPage(WebDriver driver) {
        super(driver);
    }


    public void clickLoginUserButton(){
        clickElement(loginUserButton);
    }
}
