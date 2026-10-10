
package ProductsPageScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.Baseclass;
import GenericUtility.DataProviderUtility;
import SwagLabsPom.SwagLabsCartpage;
import SwagLabsPom.SwagLabsCheckout;
import SwagLabsPom.SwagLabsLogin;
import SwagLabsPom.SwagLabsProduct;

public class ProductTest extends Baseclass {

	@Test(dataProvider = "data", dataProviderClass = DataProviderUtility.class,groups = {"FT", "Pos"})
    public void verifyProductsPage(String Username,String Password) {
		SwagLabsLogin ln=new SwagLabsLogin(driver);
		ln.login(Username,Password);
        SwagLabsProduct product = new SwagLabsProduct(driver);
        Assert.assertEquals(product.verifyProductsPage(), true,"Products page is not displayed");
        Reporter.log("Products page is displayed successfully", true);
    }

    @Test(dataProvider = "data", dataProviderClass = DataProviderUtility.class,groups = {"FT", "Pos"})
    public void addBackpack(String Username,String Password) {
    	SwagLabsLogin ln=new SwagLabsLogin(driver);
		ln.login(Username,Password);
        SwagLabsProduct product = new SwagLabsProduct(driver);
        product.clickaddtocart();
        Reporter.log("Backpack added successfully", true);
    }
    @Test(dataProvider = "data", dataProviderClass = DataProviderUtility.class,groups = {"Integration", "Pos"})
    public void productToCart(String Username,String Password) {
    	SwagLabsLogin ln=new SwagLabsLogin(driver);
		ln.login(Username,Password);
        SwagLabsProduct product = new SwagLabsProduct(driver);
        product.clickaddtocart();
        product.clickCart();
        Assert.assertEquals(driver.getCurrentUrl().contains("cart"), true,"Cart page is not displayed");
        Reporter.log("Product successfully integrated with Cart", true);
    }

    @Test(dataProvider = "data", dataProviderClass = DataProviderUtility.class,groups = {"Integration", "Pos"})
    public void productToCheckout_Test(String Username,String Password) {
    	SwagLabsLogin ln=new SwagLabsLogin(driver);
		ln.login(Username,Password);
        SwagLabsProduct product = new SwagLabsProduct(driver);
        product.clickaddtocart();
        product.clickCart();
        SwagLabsCartpage cart = new SwagLabsCartpage(driver);
        cart.clickCheckout();
        Assert.assertEquals(driver.getCurrentUrl().contains("checkout-step-one"),true,"Checkout page is not displayed");
        Reporter.log("Product page successfully integrated with Checkout page", true);
        
    }
    
    @Test(dataProvider = "data", dataProviderClass = DataProviderUtility.class,groups = {"Smoke", "Pos"})
    public void verifyProductPageSmoke(String Username,String Password) {
    	SwagLabsLogin ln=new SwagLabsLogin(driver);
		ln.login(Username,Password);
        SwagLabsProduct product = new SwagLabsProduct(driver);
        Assert.assertEquals(product.verifyProductsPage(), true,"Products page is not displayed");
        Reporter.log("Product page smoke test passed", true);
    }

    @Test(dataProvider = "data", dataProviderClass = DataProviderUtility.class,groups = {"Smoke", "Pos"})
    public void verifySortingSmoke(String Username,String Password) {
    	SwagLabsLogin ln=new SwagLabsLogin(driver);
		ln.login(Username,Password);
        SwagLabsProduct product = new SwagLabsProduct(driver);
        product.sortByNameAToZ();
        Assert.assertEquals(product.verifyProductsPage(), true,"Products page is not displayed");
        Reporter.log("Name A-Z sorting performed successfully", true);
    }

    @Test(dataProvider = "systemData", dataProviderClass = DataProviderUtility.class, groups = {"ST", "Pos"})
    public void completePurchaseSystemTest(
    		String Username,
            String Password,
            String firstName,
            String lastName,
            String postalCode) throws Exception {
    	
        SwagLabsLogin ln = new SwagLabsLogin(driver);
        ln.login(Username, Password);

        SwagLabsProduct product = new SwagLabsProduct(driver);
        product.clickaddtocart();
        product.clickCart();

        SwagLabsCartpage cart = new SwagLabsCartpage(driver);

        Assert.assertEquals(
                cart.verifyBackpackDisplayed(),
                true,
                "Backpack is not displayed in cart"
        );

        cart.clickCheckout();

        SwagLabsCheckout checkout = new SwagLabsCheckout(driver);

        checkout.enterFirstName(firstName);
        checkout.enterLastName(lastName);
        checkout.enterPostalCode(postalCode);

        checkout.clickContinue();

        Assert.assertEquals(
                checkout.verifyCheckoutOverview(),
                true,
                "Checkout Overview is not displayed"
        );

        checkout.clickFinish();

        Assert.assertEquals(
                checkout.verifyThankYouMessage(),
                true,
                "Thank You message is not displayed"
        );

        Reporter.log("Complete purchase system test passed", true);
    }
}