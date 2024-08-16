package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
   {
	
	public static void takesScreenShot(WebDriver driver, String FileName) throws IOException 
	{
		File srs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		//C:\Users\rahul\eclipse-workspace\MMM_Selenium_Practice\ScreenShot_Eclips
		File dest = new File(System.getProperty("user.dir")+"\\ScreenShot_Eclips\\"+ FileName +timeStamp+".png");
		//System.getProperty("user.dir")+"\\ScreenShot_Eclips\\"+ FileName +timeStamp+".jpg"
		FileHandler.copy(srs, dest);
		Reporter.log("saving file at location "+dest, true);
	}

	public static String radaDataFromExcel(String filepath, String Sheetnum, int rownum, int cellnum)
			throws EncryptedDocumentException, IOException 
	{
		FileInputStream myfile = new FileInputStream(filepath);
		String value = WorkbookFactory.create(myfile).getSheet(Sheetnum).getRow(rownum).getCell(cellnum)
				.getStringCellValue();
		return value;
	}

	public static String readDataFromFile(String filePath, String key) throws IOException 
	{
		FileInputStream myFile = new FileInputStream(filePath);
		Properties pop = new Properties();
		pop.load(myFile);
		String value = pop.getProperty(key);
		return value;
	}
}
