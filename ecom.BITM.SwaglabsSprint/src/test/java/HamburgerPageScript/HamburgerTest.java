

package HamburgerPageScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import SwagLabsPom.SwagLabsHamburger;
import SwagLabsPom.SwagLabsLogin;
import SwagLabsPom.SwagLabsProduct;
import GenericUtility.Baseclass;
import GenericUtility.DataProviderUtility;

public class HamburgerTest extends Baseclass {

	@Test(dataProvider = "data", dataProviderClass = DataProviderUtility.class,groups = {"FT", "Smoke"})
	public void verifyHamBurgerMenu(String Username,String Password) throws InterruptedException {
		SwagLabsLogin ln=new SwagLabsLogin(driver);
		ln.login(Username,Password);
		SwagLabsHamburger hb=new SwagLabsHamburger(driver);
		hb.getMenu();
		Assert.assertEquals(hb.verifyAllItem().isDisplayed(),true);
		Assert.assertEquals(hb.verifyLogout().isDisplayed(),true);		
		Assert.assertEquals(hb.verifyreset().isDisplayed(),true);
		Reporter.log("All Hamburger menu options are displayed successfully",true);
		hb.clickCross();

		//hb.getLogout();
		//Thread.sleep(2000);

	}

	@Test(dataProvider = "data", dataProviderClass = DataProviderUtility.class,groups={"FT","Integration"})

	public void verifyReset(String Username,String Password) {
		SwagLabsLogin ln=new SwagLabsLogin(driver);
		ln.login(Username,Password);
		SwagLabsProduct p=new SwagLabsProduct(driver);
		SwagLabsHamburger hb=new SwagLabsHamburger(driver);
		p.clickaddtocart();

	    Assert.assertEquals(p.verifyCartContains1item().getText(),"1");

	    hb.getMenu();
	    hb.getRestButton();

	    Assert.assertEquals(p.verifyCartContains1item().getText(),"");
	    Reporter.log("Reset App State successfully cleared the cart",true);
		hb.clickCross();

	    //hb.getLogout();

	}

//	@Test(dataProvider = "data", dataProviderClass = DataProviderUtility.class,groups = {"Integration", "Smoke"})
//	public void verifyLogout(String username,String password) {
//		SwagLabsLogin ln=new SwagLabsLogin(driver);
//		ln.login(username,password);
//		SwagLabsHamburger hb=new SwagLabsHamburger(driver);
//		hb.getMenu();
//		hb.getLogout();
//		Assert.assertEquals(ln.getLoginButton().isDisplayed(),true);
//		Reporter.log("application logged out successfully",true);
//	}

	@Test(dataProvider = "data", dataProviderClass = DataProviderUtility.class,groups="System")
	public void verifyCompleteHamburgerWorkflow(String Username,String Password) {
		SwagLabsLogin ln=new SwagLabsLogin(driver);
		ln.login(Username,Password);
		SwagLabsProduct p=new SwagLabsProduct(driver);
		SwagLabsHamburger hb=new SwagLabsHamburger(driver);

		p.clickaddtocart();
		Assert.assertEquals(p.verifyCartContains1item().getText(),"1");
		Reporter.log("Product added successfully",true);
		hb.getMenu();
		Assert.assertEquals(hb.verifyAllItem().isDisplayed(),true);

		Assert.assertEquals(hb.verifyLogout().isDisplayed(),true);

		Assert.assertEquals(hb.verifyreset().isDisplayed(),true);

		Reporter.log("All Hamburger menu options are displayed successfully",true);
		hb.getRestButton();

		Assert.assertEquals(p.verifyCartContains1item().getText(),"");
		Reporter.log("Reset App State successfully cleared the cart",true);
		hb.clickCross();


	}
}