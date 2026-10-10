
package LoginPageScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.Baseclass;
import GenericUtility.ScreenshotUtility;
import SwagLabsPom.SwagLabsLogin;

public class LoginPageNegative extends Baseclass {

    @Test(dataProvider = "negativeLoginData",
            dataProviderClass = GenericUtility.DataProviderUtility.class,groups = "Neg")
    public void verifyLoginWithInvalidCredentials(String Username,
            String Password) {

        SwagLabsLogin login = new SwagLabsLogin(driver);

        // Enter invalid username and valid password
        login.login(Username, Password);

        // Verify that login is unsuccessful
        Assert.assertFalse(
            driver.getCurrentUrl().contains("inventory.html"),
            "Login should not succeed with invalid credentials"
        );

        // Verify the error message
        Assert.assertTrue(
            login.getErrorMessage().contains(
                "Username and password do not match"
            ),
            "Expected error message was not displayed"
        );
        ScreenshotUtility.takeScreenshot(
        	    driver, "Negative_Login"
        	);

        Reporter.log(
            "Negative test passed: Login failed with invalid credentials",
            true
        );
        //driver.quit();
    }
}
