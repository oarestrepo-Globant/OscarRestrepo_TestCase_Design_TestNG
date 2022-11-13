package org.espn.configuration;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

public class Driver {
  private WebDriver driver;

    public Driver(String browser){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    }
  @Parameters({"url"})
  public WebDriver getDriver() {
    return driver;
  }

  public void closeBrowser(){
      getDriver().quit();
  }

  public void deleteCookies(){
      getDriver().manage().deleteAllCookies();
  }

  public void getUrl(){
      driver.get("https://www.espnqa.com/?src=com&_adblock=true&espn=cloud ");
  }

  public void maximizeWindow(){
      getDriver().manage().window().maximize();
  }

}
