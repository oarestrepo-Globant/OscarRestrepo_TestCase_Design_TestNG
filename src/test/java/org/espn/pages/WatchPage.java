package org.espn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchPage extends BasePage {
    //Vista que contiene los caruseles => #fittPageContainer > section > div:nth-child()
    @FindBy(css="#fittPageContainer > section")
    private List<WebElement> carouselContainersList;

    @FindBy(css="#fittPageContainer > section > div:nth-child(1) > section > div.Carousel__Wrapper.relative.Carousel__Wrapper--canScrollRight > div > div > ul")
    private WebElement carousel1;

    @FindBy(css="#fittPageContainer > section > div:nth-child(1) > section > div.Carousel__Wrapper.relative.Carousel__Wrapper--canScrollRight > div > div > ul > li:nth-child(2) > a")
    private WebElement secondCardOfFirstCarousel;

    @FindBy(css = ".lightbox__closebtn")
    //.icon--color > use
    //.lightbox__closebtn
    private WebElement xButtonFromSupplierModal;


    public WatchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCarouselContainerAndContainersDisplayed(){
        super.waitForVisibility(carouselContainersList);
        return carouselContainersList.size() > 0;
    }

    public void clickSecondCardFromFirstCarrousel(){
        super.clickElement(secondCardOfFirstCarousel);
    }

    public boolean isXButtonFromSupplierModalPresent(){
        clickSecondCardFromFirstCarrousel();
        super.waitForVisibility(xButtonFromSupplierModal);
        return xButtonFromSupplierModal.isDisplayed();
    }
    public void clickXButtonFromSupplierModal(){
        super.clickElement(xButtonFromSupplierModal);
    }

    public HomePage backToHomePage(){
        super.backToPreviousPage();
        return new HomePage(getDriver());
    }

}
