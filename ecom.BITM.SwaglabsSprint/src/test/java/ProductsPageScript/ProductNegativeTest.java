package ProductsPageScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.Baseclass;
import GenericUtility.DataProviderUtility;
import SwagLabsPom.SwagLabsLogin;
import SwagLabsPom.SwagLabsProduct;

public class ProductNegativeTest extends Baseclass {

    @Test(
        dataProvider = "data",
        dataProviderClass = DataProviderUtility.class,
        groups = "Neg"
    )
    public void verifyProductNotAddedWithoutClickingAddToCart(
            String Username,
            String Password) {

        // Login
        SwagLabsLogin ln = new SwagLabsLogin(driver);
        ln.login(Username, Password);

        // Product Page
        SwagLabsProduct product = new SwagLabsProduct(driver);

        // Do NOT click Add to Cart

        // Verify cart is empty
        Assert.assertEquals(
                product.verifyCartContains1item().getText(),
                "",
                "Cart should be empty when no product is added"
        );

        Reporter.log(
                "Negative test passed: Product was not added without clicking Add to Cart",
                true
        );
    }
}