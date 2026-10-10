package CartPageScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.Baseclass;
import GenericUtility.DataProviderUtility;
import SwagLabsPom.SwagLabsCartpage;
import SwagLabsPom.SwagLabsLogin;
import SwagLabsPom.SwagLabsProduct;

public class CartpageNegativeTest extends Baseclass {

	@Test(
	        dataProvider = "data",
	        dataProviderClass = DataProviderUtility.class,
	        groups =  "Neg"
	    )
	    public void verifyEmptyCartDoesNotShowProduct(
	            String Username,
	            String Password) {

	        // Login
	        SwagLabsLogin ln = new SwagLabsLogin(driver);
	        ln.login(Username, Password);

	        // Product Page
	        SwagLabsProduct product = new SwagLabsProduct(driver);

	        // Do NOT add any product
	        product.clickCart();

	        // Cart Page
	        SwagLabsCartpage cart = new SwagLabsCartpage(driver);

	        // Verify product is NOT displayed
	        Assert.assertNotEquals(product.verifyCartContains1item(),"1");

	        Reporter.log( "Negative test passed: Empty cart does not show any product",true);
        
    }
}