
package CheckoutPageScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.Baseclass;
import GenericUtility.DataProviderUtility;
import GenericUtility.ScreenshotUtility;
import SwagLabsPom.SwagLabsLogin;
import SwagLabsPom.SwagLabsProduct;
import SwagLabsPom.SwagLabsCartpage;
import SwagLabsPom.SwagLabsCheckout;

public class CheckoutNegative extends Baseclass {


	@Test(dataProvider="readcheckoutdata",dataProviderClass = DataProviderUtility.class,groups = "Neg")
	public void verifyCheckoutTextFieldFN(String Username,
            String Password,
            String Firstname,
            String Lastname,
            String Postalcode) throws InterruptedException {
		 SwagLabsLogin login = new SwagLabsLogin(driver);
	     login.login(Username, Password);
	     
	     SwagLabsProduct p=new SwagLabsProduct(driver);
	     p.clickaddtocart();
	     p.clickCart();
	     
	     SwagLabsCartpage c=new SwagLabsCartpage(driver);
	     c.clickCheckout();
	     
	     SwagLabsCheckout checkout = new SwagLabsCheckout(driver);
	     checkout.enterFirstName(Firstname);
	     checkout.enterLastName(Lastname);
	     checkout.enterPostalCode(Postalcode);
	     checkout.clickContinue();
	     Assert.assertEquals(checkout.getErrorMessage(),"Error: First Name is required");
	     ScreenshotUtility.takeScreenshot(
	    		    driver, "Negative_Checkout"
	    		);
	     Reporter.log("PASS: First Name,Last Name , ZipCode validation verified", true);
        
    }
}
