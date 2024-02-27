//Step6 : POM for Step 1  to 5
package org.amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Set;

public class BaseClass {
    public WebDriver driver;

    By signinLink = By.id("nav-link-accountList-nav-line-1");
    By usernameInput = By.id("ap_email");
    By passwordInput = By.id("ap_password");
    By continueButton = By.id("continue");
    By submitButton = By.id("signInSubmit");
    By productLocator = By.xpath(
            "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']//span[@class='a-size-base-plus a-color-base a-text-normal'][contains(text(),'SOLARA Insulated Water Bottle 650ml, Hot Water Bot')]");
    By searchInput = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");
    By addtocartButton = By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']");
    By homeButton = By.id("nav-logo");
    By viewCartButton = By.id("nav-cart");
    By productTitle = By.xpath("//span[@class='a-truncate-cut']");


   public void browserSetup() {


            //setup Chrome browser
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();

            //Add options for --headed or --headless browser launch
            chromeOptions.addArguments("-headed");

            //initialize driver for chrome
            driver = new ChromeDriver(chromeOptions);

       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
   }

    public void switchWindow(int index) {
        Set<String> handles = driver.getWindowHandles();
        driver.switchTo().window(handles.toArray()[index].toString());
    }

    public void navigateTo(String url){
        driver.get(url);
        driver.getCurrentUrl().equalsIgnoreCase(url);
    }

    public void clickOnSigninOption() {
        driver.findElement(signinLink).click();
    }

    public void enterUserName(String username) {
        driver.findElement(usernameInput).isDisplayed();
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void clickOnContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).isDisplayed();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickOnSubmitButton(){
        driver.findElement(submitButton).click();
    }

    public void searchProduct(String searchProductName) {
        driver.findElement(searchInput).sendKeys(searchProductName);
    }


    public void clickOnProductName() {
        driver.findElement(productLocator).click();
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void clickOnAddToCartButton(){driver.findElement(addtocartButton).click();}

    public void clickOnHomeButton(){driver.findElement(homeButton).click();}

    public void clickOnViewCartButton(){driver.findElement(viewCartButton).click();}
    public void verifyProductTitle(){driver.findElement(productTitle).isDisplayed();}
}