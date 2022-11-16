package org.espn.tests;

import org.espn.configuration.Driver;
import org.espn.pages.HomePage;
import org.espn.reporting.Logger;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import static java.lang.String.format;

public class BaseTest  {
    protected Driver driver;
    protected HomePage home;
    @DataProvider(name = "credentialsToLogin")
    public Object[][] getUsersLoginData() {
        return new Object[][]{{"elmail@jolmail.com", "prueba123"}};
    }
    @Parameters({"browser", "url"})
    @BeforeTest
    public void testSetup(String browser, String url) {
        driver = new Driver(browser);
        Logger.info("Deleting all cookies");
        driver.deleteCookies();
        Logger.info(format("Navigating to %s", url));
        driver.getUrl();
        driver.maximizeWindow();
        home = new HomePage(driver.getDriver());
    }

   /* @BeforeMethod
    public void closeBottomBanner(){
        if (home.isPromoBannerContainerDisplayed()) {
            home.closeBannerContainer();
        }
    }*/

   /* @AfterTest
    public void tearDown(){
        driver.closeBrowser();
    }*/

    protected <T> void checkThat(String description, T actualValue, Matcher<? super T> expectedValue) {
        Logger.info(format("Checking that " + description.toLowerCase() + " [Expectation: %s]", expectedValue));
        try {
            MatcherAssert.assertThat(actualValue, expectedValue);
        } catch (AssertionError e) {
            Logger.error(format("Assertion Error: [%s]", e.getMessage().replaceAll("\n", "")));
        }
    }

    public Driver getDriver() {
        return driver;
    }

    protected void deleteCookies(){
        getDriver().deleteCookies();
    }
}
