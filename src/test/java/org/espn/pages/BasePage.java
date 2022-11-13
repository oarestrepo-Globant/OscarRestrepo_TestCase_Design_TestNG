package org.espn.pages;

import org.espn.configuration.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends WebOperations{

    @FindBy(id ="global-nav")
    private WebElement globalNav;
    @FindBy(id ="global-user-trigger")
    private WebElement userIcon;
    public BasePage(WebDriver driver) {
        super(driver);
    }

    public boolean isGlobalNavDisplayed(){
        return globalNav.isDisplayed();
    }
    public void clickUserIcon(){
        clickElement(userIcon);
    }

    public void placeMouseOnUserIcon(){
    placeMouseToElement(userIcon);
    }
}
