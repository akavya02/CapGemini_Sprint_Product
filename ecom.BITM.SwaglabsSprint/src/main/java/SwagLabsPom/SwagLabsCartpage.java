package SwagLabsPom;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabsCartpage {

    WebDriver driver;

    public SwagLabsCartpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    private WebElement backpackName;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(xpath="//button[text()='Remove']")
	private WebElement removeButton;

    public void getRemove() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    wait.until(ExpectedConditions.refreshed(
	        ExpectedConditions.elementToBeClickable(removeButton)
	    )).click();
		
	}

    public boolean verifyBackpackDisplayed() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            return wait.until(d -> {
                try {
                    return backpackName.isDisplayed();
                } catch (StaleElementReferenceException e) {
                    return false;
                }
            });
        } catch (Exception e) {
            return false;
        }
    }
    public WebElement verifyproduct()
    {
    	return backpackName;
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
}