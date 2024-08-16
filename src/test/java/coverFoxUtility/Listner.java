package coverFoxUtility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFoxBase.Base;

public class Listner extends Base implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) 
	{
		Reporter.log(" TC Started "+result.getName(), false);
		try {
			Utility.takesScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("TC Failure", true);
		try {
			Utility.takesScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
