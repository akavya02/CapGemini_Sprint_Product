package HamburgerPageScript;

import org.testng.Assert;
import org.testng.annotations.Test;


import SwagLabsPom.SwagLabsHamburger;
import SwagLabsPom.SwagLabsLogin;
import SwagLabsPom.SwagLabsProduct;
import GenericUtility.Baseclass;
import GenericUtility.DataProviderUtility;

public class HamburgerNegativeTest extends Baseclass {

	@Test(dataProvider = "data", dataProviderClass = DataProviderUtility.class,groups = "Neg")
    public void verifyResetAppStateWithEmptyCart(String Username,String Password) {

        SwagLabsProduct product = new SwagLabsProduct(driver);
        SwagLabsHamburger hamburger = new SwagLabsHamburger(driver);
        SwagLabsLogin login = new SwagLabsLogin(driver);
        login.login(Username, Password);

        // Pre-condition: User is logged in and cart is empty
        Assert.assertEquals(product.verifyCartContains1item().getText(),"", "Cart is not empty before executing the test");

        // Open Hamburger menu
        hamburger.getMenu();

        // Click Reset App State
        hamburger.getRestButton();

        // Verify application remains on Products page
        Assert.assertTrue(product.verifyProductsPage(),"Application is not on Products page");

        // Verify cart is still empty
        Assert.assertEquals(product.verifyCartContains1item().getText(),"", "Cart is not empty before executing the test");
        hamburger.clickCross();
        
    }
    
}