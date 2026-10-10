package CheckoutPageScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.Baseclass;
import GenericUtility.DataProviderUtility;
import SwagLabsPom.SwagLabsCartpage;
import SwagLabsPom.SwagLabsCheckout;
import SwagLabsPom.SwagLabsLogin;
import SwagLabsPom.SwagLabsProduct;

public class Checkoutpage extends Baseclass {

    
    @Test(
        dataProvider = "systemData",
        dataProviderClass = DataProviderUtility.class,
        groups = {"FT", "Pos"}
    )
    public void verifyCheckoutWithValidDetails(
            String Username,
            String Password,
            String Firstname,
            String Lastname,
            String Postalcode) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);
        
        product.clickaddtocart();
        product.clickCart();

        SwagLabsCartpage cart = new SwagLabsCartpage(driver);
        cart.clickCheckout();

        SwagLabsCheckout checkout = new SwagLabsCheckout(driver);

        checkout.enterFirstName(Firstname);
        checkout.enterLastName(Lastname);
        checkout.enterPostalCode(Postalcode);

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"),"Checkout page is not displayed");

        Reporter.log("Functionality test passed: Valid checkout details accepted",true);
    }


    
    @Test(
        dataProvider = "systemData",
        dataProviderClass = DataProviderUtility.class,
        groups = {"FT", "Pos"}
    )
    public void verifyCheckoutPageDisplayed(
            String Username,
            String Password,
            String Firstname,
            String Lastname,
            String Postalcode) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);
        product.clickaddtocart();
        product.clickCart();

        SwagLabsCartpage cart = new SwagLabsCartpage(driver);
        cart.clickCheckout();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"),"Checkout page is not displayed");

        Reporter.log("Functionality test passed: Checkout page displayed",true);
    }


    @Test(
        dataProvider = "systemData",
        dataProviderClass = DataProviderUtility.class,
        groups = {"Integration", "Pos"}
    )
    public void verifyLoginToCheckoutIntegration(
            String Username,
            String Password,
            String Firstname,
            String Lastname,
            String Postalcode) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);
        product.clickaddtocart();
        product.clickCart();

        SwagLabsCartpage cart = new SwagLabsCartpage(driver);
        Assert.assertTrue(cart.verifyBackpackDisplayed(),"Backpack is not displayed in cart");

        cart.clickCheckout();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"),"Checkout page is not displayed");

        Reporter.log("Integration test passed: Login -> Product -> Cart -> Checkout",true);
    }


    
    @Test(
        dataProvider = "systemData",
        dataProviderClass = DataProviderUtility.class,
        groups = {"Integration", "Pos"}
    )
    public void verifyCartToCheckoutDetails(
            String Username,
            String Password,
            String Firstname,
            String Lastname,
            String Postalcode) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);
        product.clickaddtocart();
        product.clickCart();

        SwagLabsCartpage cart = new SwagLabsCartpage(driver);
        cart.clickCheckout();

        SwagLabsCheckout checkout = new SwagLabsCheckout(driver);

        checkout.enterFirstName(Firstname);
        checkout.enterLastName(Lastname);
        checkout.enterPostalCode(Postalcode);

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"),"Checkout page is not displayed");

        Reporter.log("Integration test passed: Cart -> Checkout details",true);
    }


   
    @Test(
        dataProvider = "systemData",
        dataProviderClass = DataProviderUtility.class,
        groups = {"Smoke", "Pos"}
    )
    public void verifyCheckoutSmoke(
            String Username,
            String Password,
            String Firstname,
            String Lastname,
            String Postalcode) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);
        product.clickaddtocart();
        product.clickCart();

        SwagLabsCartpage cart = new SwagLabsCartpage(driver);
        cart.clickCheckout();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"),"Checkout smoke test failed");

        Reporter.log("Smoke test passed: Checkout page opened",true);
    }


    
    @Test(
        dataProvider = "systemData",
        dataProviderClass = DataProviderUtility.class,
        groups = {"Smoke", "Pos"}
    )
    public void verifyCheckoutDetailsSmoke(
            String Username,
            String Password,
            String Firstname,
            String Lastname,
            String Postalcode) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);
        product.clickaddtocart();
        product.clickCart();

        SwagLabsCartpage cart = new SwagLabsCartpage(driver);
        cart.clickCheckout();

        SwagLabsCheckout checkout = new SwagLabsCheckout(driver);

        checkout.enterFirstName(Firstname);
        checkout.enterLastName(Lastname);
        checkout.enterPostalCode(Postalcode);

        Reporter.log("Smoke test passed: Checkout details entered successfully",true);
    }


    
    @Test(
        dataProvider = "systemData",
        dataProviderClass = DataProviderUtility.class,
        groups = {"ST", "Pos"}
    )
    public void verifyCompleteCheckoutWorkflow(
            String Username,
            String Password,
            String Firstname,
            String Lastname,
            String Postalcode) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);
        product.clickaddtocart();
        product.clickCart();

        SwagLabsCartpage cart = new SwagLabsCartpage(driver);
        cart.clickCheckout();

        SwagLabsCheckout checkout = new SwagLabsCheckout(driver);

        checkout.enterFirstName(Firstname);
        checkout.enterLastName(Lastname);
        checkout.enterPostalCode(Postalcode);

        // Use your existing Continue method here
        checkout.clickContinue();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"),"Checkout overview page is not displayed");

        Reporter.log("System test passed: Complete checkout workflow",true);
    }


    
    @Test(
        dataProvider = "systemData",
        dataProviderClass = DataProviderUtility.class,
        groups = {"ST", "Pos"}
    )
    public void verifyOrderCompletion(
            String Username,
            String Password,
            String Firstname,
            String Lastname,
            String Postalcode) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);
        product.clickaddtocart();
        product.clickCart();

        SwagLabsCartpage cart = new SwagLabsCartpage(driver);
        cart.clickCheckout();

        SwagLabsCheckout checkout = new SwagLabsCheckout(driver);

        checkout.enterFirstName(Firstname);
        checkout.enterLastName(Lastname);
        checkout.enterPostalCode(Postalcode);

        checkout.clickContinue();
        checkout.clickFinish();

        Assert.assertTrue(checkout.verifyThankYouMessage(),"Thank You message is not displayed");
        Reporter.log("System test passed: Order completed successfully",true);
    }
}