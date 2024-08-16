package coverFoxBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

public class Base 
{

	static protected  WebDriver driver;
	public void openBrowser() throws InterruptedException 
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		 driver=new ChromeDriver(opt);
		 driver.manage().window().maximize();
		driver.get("https://www.coverfox.com/");
		
		Thread.sleep(2000);
		
	}
	
	public void tearDown() 
	{
		
		driver.close();
	}
	
}
