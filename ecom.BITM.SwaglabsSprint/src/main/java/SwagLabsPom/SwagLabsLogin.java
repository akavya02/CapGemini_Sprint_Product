package SwagLabsPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsLogin {

    WebDriver driver;

    public SwagLabsLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameTF;

    @FindBy(id = "password")
    private WebElement passwordTF;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public WebElement getUsernameTF() {
		return usernameTF;
	}



	public WebElement getPasswordTF() {
		return passwordTF;
	}



	public WebElement getLoginButton() {
		return loginButton;
	}



	public void login(String Username,String Password) {
    	usernameTF.clear();
    	usernameTF.sendKeys(Username);
    	passwordTF.clear();
    	passwordTF.sendKeys(Password);
    	loginButton.click();
}
	public String getErrorMessage() {
        return errorMessage.getText();
    }
}