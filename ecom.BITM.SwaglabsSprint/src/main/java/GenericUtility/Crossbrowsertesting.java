////package GenericUtility;
////
////import java.time.Duration;
////import java.util.HashMap;
////import java.util.Map;
////
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.chrome.ChromeDriver;
////import org.openqa.selenium.chrome.ChromeOptions;
////import org.openqa.selenium.edge.EdgeDriver;
////import org.openqa.selenium.firefox.FirefoxDriver;
////
////public class Crossbrowsertesting {
////	WebDriver driver=null;
////	public WebDriver launchBrowser(String browser) {
////		if(browser.equalsIgnoreCase("chrome")) {
////			 driver = new ChromeDriver();
////		ChromeOptions settings = new ChromeOptions();
////		Map<String, Object> prefs = new HashMap<>();
////		prefs.put("profile.password_manager_leak_detection", false);
////		settings.setExperimentalOption("prefs", prefs);
////		
////		driver=new ChromeDriver(settings);
////		}
////		
////		else if(browser.equalsIgnoreCase("edge"))
////			 driver = new EdgeDriver();
////		else if(browser.equalsIgnoreCase("firefox"))
////			 driver = new FirefoxDriver();
////		else
////			 driver = new ChromeDriver();
////		
////		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
////		
////		
////		return driver;
////	}
////}
//
//
//package GenericUtility;
//
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//public class Crossbrowsertesting {
//
//    WebDriver driver = null;
//
//    public WebDriver launchBrowser(String browser) {
//
//        if (browser.equalsIgnoreCase("chrome")) {
//
//            ChromeOptions settings = new ChromeOptions();
//
//            Map<String, Object> prefs = new HashMap<>();
//            prefs.put("profile.password_manager_leak_detection", false);
//
//            settings.setExperimentalOption("prefs", prefs);
//
//            driver = new ChromeDriver(settings);
//        }
//
//        else if (browser.equalsIgnoreCase("edge")) {
//            driver = new EdgeDriver();
//        }
//
//        else if (browser.equalsIgnoreCase("firefox")) {
//            driver = new FirefoxDriver();
//        }
//
//        else {
//            driver = new ChromeDriver();
//        }
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//
//        return driver;
//    }
//}



package GenericUtility;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Crossbrowsertesting {
	WebDriver driver=null;
	public WebDriver launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);

		driver=new ChromeDriver(settings);
		}

		else if(browser.equalsIgnoreCase("edge"))
			 driver = new EdgeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			 driver = new FirefoxDriver();
		else
			 driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));


		return driver;
	}
}