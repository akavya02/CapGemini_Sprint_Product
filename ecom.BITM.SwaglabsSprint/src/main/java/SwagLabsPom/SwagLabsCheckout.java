package SwagLabsPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsCheckout {

    WebDriver driver;

    public SwagLabsCheckout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement firstNameTF;

    @FindBy(id = "last-name")
    private WebElement lastNameTF;

    @FindBy(id = "postal-code")
    private WebElement postalCodeTF;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    private WebElement checkoutOverviewText;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    private WebElement thankYouMessage;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public void enterFirstName(String firstName) {
    	firstNameTF.clear();
        firstNameTF.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
    	lastNameTF.clear();
        lastNameTF.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
    	postalCodeTF.clear();
        postalCodeTF.sendKeys(postalCode);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public boolean verifyCheckoutOverview() {
        return checkoutOverviewText.isDisplayed();
    }

    public void clickFinish() {
        finishButton.click();
    }

    public boolean verifyThankYouMessage() {
        return thankYouMessage.isDisplayed();
    }
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}