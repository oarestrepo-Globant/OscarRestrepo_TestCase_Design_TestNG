package org.espn.tests;

import org.espn.configuration.Driver;
import org.espn.pages.HomePage;
import org.espn.reporting.Logger;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static java.lang.String.format;

public class BaseTest  {
    protected Driver driver;
    private HomePage home;

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
    /*@AfterTest
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
}
