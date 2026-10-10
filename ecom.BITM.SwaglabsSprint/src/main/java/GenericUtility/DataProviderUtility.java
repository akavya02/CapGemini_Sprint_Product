package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataProviderUtility {

	@DataProvider(name = "data")
	  public Object[][] data()throws EncryptedDocumentException, IOException {

	     FileInputStream fis =new FileInputStream("./src/test/resources/swaglabs/SauceDemo.xlsx");
	     Workbook wb = WorkbookFactory.create(fis);
	     Sheet sh = wb.getSheet("Sheet1");
	     int rowCount = sh.getLastRowNum();
	     Object[][] obj = new Object[rowCount][2];
	     for (int row = 1; row <= rowCount; row++) {
	        obj[row - 1][0]=sh.getRow(row).getCell(0).getStringCellValue();
	        obj[row - 1][1]=sh.getRow(row).getCell(1).getStringCellValue();

	    }

	    wb.close();
	    fis.close();

	    return obj;
	}
	@DataProvider(name = "systemData")
	public Object[][] systemData() throws Exception {

	    FileInputStream fis = new FileInputStream(
	            "./src/test/resources/swaglabs/SauceDemo.xlsx");

	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet("Sheet1");

	    Object[][] obj = new Object[1][5];

	    obj[0][0] = sh.getRow(1).getCell(0).getStringCellValue();
	    obj[0][1] = sh.getRow(1).getCell(1).getStringCellValue();
	    obj[0][2] = sh.getRow(1).getCell(2).getStringCellValue();
	    obj[0][3] = sh.getRow(1).getCell(3).getStringCellValue();
	    obj[0][4] = sh.getRow(1).getCell(4).toString();

	    wb.close();
	    fis.close();

	    return obj;
	}
	    
	    
	    @DataProvider(name = "negativeLoginData")
		  public Object[][] negativeLoginData()throws EncryptedDocumentException, IOException {

		     FileInputStream fis =new FileInputStream("./src/test/resources/swaglabs/SauceDemo.xlsx");
		     Workbook wb = WorkbookFactory.create(fis);
		     Sheet sh = wb.getSheet("Sheet2");
		     Object[][] obj = new Object[1][2];

		     obj[0][0] = sh.getRow(1).getCell(0).getStringCellValue();
		     obj[0][1] = sh.getRow(1).getCell(1).getStringCellValue();

		    

		    wb.close();
		    fis.close();

		    return obj;
		}


@DataProvider(name = "readcheckoutdata")
public Object[][] readcheckoutdata() throws Exception {

    FileInputStream fis = new FileInputStream(
        "./src/test/resources/swaglabs/SauceDemo.xlsx"
    );

    Workbook wb = WorkbookFactory.create(fis);
    Sheet sh = wb.getSheet("Sheet3");

    Object[][] obj = new Object[1][5];

    Row row = sh.getRow(1); // First data row; row 0 contains headers

    for (int j = 0; j < 5; j++) {
        Cell cell = (row == null) ? null : row.getCell(j);
        obj[0][j] = (cell == null) ? "" : cell.toString().trim();
    }
    

    wb.close();
    fis.close();

    return obj;
		}
	
}
