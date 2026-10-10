//package GenericUtility;
//
//import java.io.FileInputStream;
//import java.util.Properties;
//
//public class FileUtility {
//	public String getDataFromPropertyFile(String key) throws Exception{
//		FileInputStream fis = new FileInputStream("./src/main/resources/SauceDemo.properties");
//		Properties p = new Properties();
//		p.load(fis);
//		
//		return p.getProperty(key);
//	}
//}

package GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertyFile(String key) throws Exception{
		FileInputStream fis = new FileInputStream("./src/main/resources/SauceDemo.properties");
		Properties p = new Properties();
		p.load(fis);

		return p.getProperty(key);
	}
}