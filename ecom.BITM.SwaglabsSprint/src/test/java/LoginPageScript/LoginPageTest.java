package LoginPageScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.Baseclass;
import GenericUtility.DataProviderUtility;
import SwagLabsPom.SwagLabsCartpage;
import SwagLabsPom.SwagLabsLogin;
import SwagLabsPom.SwagLabsProduct;

public class LoginPageTest extends Baseclass {


    @Test(
        dataProvider = "data",
        dataProviderClass = GenericUtility.DataProviderUtility.class,
        groups = {"FT", "Pos"}
    )
    public void verifyLoginWithValidCredentials(
            String Username,
            String Password) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);

        Assert.assertTrue(product.verifyProductsPage(),"Products page is not displayed");

        Reporter.log("Functionality test passed: Login successful",true);
    }


    
    @Test(
        dataProvider = "data",
        dataProviderClass = DataProviderUtility.class,
        groups = {"FT", "Pos"}
    )
    public void verifyLoginAndProductsPage(
            String Username,
            String Password) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);

        Assert.assertTrue(product.verifyProductsPage(),"Products page is not displayed");

        Reporter.log("Functionality test passed: Products page displayed",true);
    }


    
    @Test(
        dataProvider = "data",
        dataProviderClass = DataProviderUtility.class,
        groups = {"Integration", "Pos"}
    )
    public void verifyLoginAndNavigationToProducts(
            String Username,
            String Password) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);

        Assert.assertTrue(product.verifyProductsPage(),"Navigation to Products page failed");

        Reporter.log("Integration test passed: Login -> Products",true);
    }


    
    @Test(
        dataProvider = "data",
        dataProviderClass = DataProviderUtility.class,
        groups = {"Integration", "Pos"}
    )
    public void verifyLoginAndNavigationToCart(
            String Username,
            String Password) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);

        Assert.assertTrue(product.verifyProductsPage(),"Products page is not displayed");

        product.clickCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"),"Cart page is not displayed");

        Reporter.log("Integration test passed: Login -> Products -> Cart",true);
    }


    @Test(
        dataProvider = "data",
        dataProviderClass = DataProviderUtility.class,
        groups = {"Smoke", "Pos"}
    )
    public void verifyLoginSmoke(
            String Username,
            String Password) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        Assert.assertTrue( driver.getCurrentUrl().contains("inventory.html"),"Login smoke test failed");

        Reporter.log("Smoke test passed: Login successful",true);
    }


    
    @Test(
        dataProvider = "data",
        dataProviderClass = DataProviderUtility.class,
        groups = {"Smoke", "Pos"}
    )
    public void verifyLoginButtonFunctionality(
            String Username,
            String Password) {

        SwagLabsLogin login = new SwagLabsLogin(driver);

        Assert.assertTrue(login.getLoginButton().isDisplayed(), "Login button is not displayed");

        login.login(Username, Password);

        Assert.assertTrue( driver.getCurrentUrl().contains("inventory.html"), "Login button did not perform login");

        Reporter.log("Smoke test passed: Login button works",
                true
        );
    }


    
    @Test(
        dataProvider = "data",
        dataProviderClass = DataProviderUtility.class,
        groups = {"ST", "Pos"}
    )
    public void verifyCompleteLoginToCartWorkflow(
            String Username,
            String Password) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);

        Assert.assertTrue(product.verifyProductsPage(),"Products page is not displayed");

        product.clickCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"),"Cart page is not displayed");

        Reporter.log("System test passed: Login -> Products -> Cart",true);
    }


    @Test(
        dataProvider = "data",
        dataProviderClass = DataProviderUtility.class,
        groups = {"ST", "Pos"}
    )
    public void verifyCompleteLoginToCheckoutWorkflow(
            String Username,
            String Password) {

        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);

        Assert.assertTrue(product.verifyProductsPage(),"Products page is not displayed");

        product.clickaddtocart();
        product.clickCart();

        SwagLabsCartpage cart = new SwagLabsCartpage(driver);

        Assert.assertTrue(cart.verifyBackpackDisplayed(),"Backpack is not displayed in Cart");

        cart.clickCheckout();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"),"Checkout page is not displayed");

        Reporter.log("System test passed: Login -> Products -> Cart -> Checkout",true);
    }
}