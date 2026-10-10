
package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

    public static String takeScreenshot(WebDriver driver, String testName) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS")
                .format(new Date());

        String browser = "Browser";

        try {
            String userAgent = driver.getCurrentUrl();
            if (userAgent != null) {
                browser = driver.getClass().getSimpleName();
            }
        } catch (Exception e) {
            // Keep default browser label
        }

        String folderPath = "./srcshot/";
        File folder = new File(folderPath);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        String fileName = testName + "_" + browser + "_" + timestamp + ".png";
        File destination = new File(folder, fileName);

        try {
            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            FileHandler.copy(source, destination);

            System.out.println("Screenshot saved: "
                    + destination.getAbsolutePath());

            return destination.getAbsolutePath();

        } catch (IOException e) {
            throw new RuntimeException("Unable to save screenshot", e);
        }
    }
}
