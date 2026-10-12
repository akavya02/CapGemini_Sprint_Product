//package SwagLabsPom;
//
//import java.time.Duration;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class SwagLabsHamburger {
//	WebDriver driver;
//	WebDriverWait wait;
//
//	public SwagLabsHamburger(WebDriver driver) {
//		this.driver=driver;
//		PageFactory.initElements( driver,this);
//
//		 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	}
//
//	@FindBy(id="react-burger-menu-btn")
//	private  WebElement menu;
//
//	@FindBy(id="reset_sidebar_link")
//	private WebElement restButton;
//
//	@FindBy(id="logout_sidebar_link")
//	private WebElement logout;
//
//	@FindBy(id="inventory_sidebar_link")
//	private WebElement allItem;
//
//	@FindBy(id="react-burger-cross-btn")
//	private WebElement crossbutton;
//	
//	public void clickCross() {
//		 crossbutton.click();
//	}
//	public void getMenu() {
//		 menu.click();
//		 wait.until(ExpectedConditions.visibilityOf(allItem));
//	}
//	
//
//	public void getRestButton() {
//		restButton.click();
//	}
//	
//
//	public void getLogout() {
//		logout.click();
//	}
//
//	public WebElement verifyreset() {
//		return restButton;
//	}
//
//	public WebElement verifyAllItem() {
//		return allItem ;
//	}
//
//	public WebElement verifyLogout() {
//		return  logout;
//	}
//
//}


package SwagLabsPom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLabsHamburger {
	WebDriver driver;
	WebDriverWait wait;
	//JavascriptExecutor js = (JavascriptExecutor)driver;

	public SwagLabsHamburger(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(id="react-burger-menu-btn")
	private  WebElement menu;

	@FindBy(id="reset_sidebar_link")
	private WebElement restButton;

	@FindBy(id="logout_sidebar_link")
	private WebElement logoutButton;

	@FindBy(id="inventory_sidebar_link")
	private WebElement allItem;

	@FindBy(id="react-burger-cross-btn")
	private WebElement crossbutton;
	
	public void clickCross() {
		 crossbutton.click();
	}
	public void getMenu() {
		//wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
		

	    wait.until(ExpectedConditions.visibilityOf(menu));
	    wait.until(ExpectedConditions.elementToBeClickable(menu));
	    menu.click();
	    wait.until(ExpectedConditions.visibilityOf(allItem));
	   
			 
	}
	

	public void getRestButton() {
		
		restButton.click();
	}
	

	public void getLogout() {
		
		logoutButton.click();
	}

	public WebElement verifyreset() {
		return restButton;
	}

	public WebElement verifyAllItem() {
		return allItem ;
	}

	public WebElement verifyLogout() {
		return  logoutButton;
	}
	
	public void logout( ) {
		getMenu();
		getRestButton();
		getLogout();
		
		}
	
	

}