package SwagLabsPom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabsProduct {

    WebDriver driver;

    public SwagLabsProduct(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    // Products heading
    @FindBy(xpath = "//span[text()='Products']")
    private WebElement productsText;

    // Sort dropdown
    @FindBy(className = "product_sort_container")
    private WebElement sortDropdown;

    // Add Backpack to Cart
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;


    // Verify Products Page
    public boolean verifyProductsPage() {

        return productsText.isDisplayed();
    }


    // Sort by Name A-Z
    public void sortByNameAToZ() {

        Select select = new Select(sortDropdown);

        select.selectByVisibleText("Name (A to Z)");
    }


    // Sort by Price Low to High
    public void sortByPriceLowToHigh() {

        Select select = new Select(sortDropdown);

        select.selectByVisibleText("Price (low to high)");
    }


     //Add Backpack
    public void clickaddtocart() {
    	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(backpackAddButton)).click();
    }

    


    public void clickCart() {

        cartIcon.click();
    }

    public WebElement verifyCartContains1item()
    {
    	return cartIcon;
    }

}