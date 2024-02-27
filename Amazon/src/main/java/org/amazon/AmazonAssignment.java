package org.amazon;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonAssignment extends BaseClass{

    @BeforeClass
    public void launchBrowser(){
       browserSetup();
    }

    @Test
    public void assignment() {
        // Step 1:- Navigate to Ecommerce website

        navigateTo("https://www.Amazon.in");
       // As it asks for CAPTCHA in the beginning, so it needs to be entered manually.

        // Step 2:- Login with username and password

        clickOnSigninOption();
        enterUserName("7224011728");
        clickOnContinueButton();

        enterPassword("India@12345");
        clickOnSubmitButton();

        //Step 3:- Find a product and add it to the cart

        searchProduct("SOLARA Insulated Water Bottle");
        clickOnSearchButton();
        clickOnProductName();
        switchWindow(1);
        clickOnAddToCartButton();

        //Step 4 :- Go back to the home page

        clickOnHomeButton();

        //Step 5 :- Verify cart on Home Page

        clickOnViewCartButton();
        verifyProductTitle();
      driver.quit();



    }


}