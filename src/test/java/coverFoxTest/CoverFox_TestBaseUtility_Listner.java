package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPOM.CoverFoxMemberDetailsPage;
import coverFoxPOM.CoverFox_HealthPlanpage;
import coverFoxPOM.coverFoxAddressDetailesPage;
import coverFoxPOM.coverFoxHomePage;
import coverFoxPOM.coverFoxResultPage;
import coverFoxUtility.Utility;


public class CoverFox_TestBaseUtility_Listner extends Base {

	coverFoxHomePage homePage;
	CoverFox_HealthPlanpage healthPlanPage;
	coverFoxAddressDetailesPage addressDetailPage;
	coverFoxResultPage resultPage;
	CoverFoxMemberDetailsPage memberDetailPage;
	String filePath;
	public static Logger logger;

	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		logger = logger.getLogger("CoverFox");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("open Browser");
		openBrowser();
		homePage = new coverFoxHomePage(driver);
		healthPlanPage = new CoverFox_HealthPlanpage(driver);
		memberDetailPage = new CoverFoxMemberDetailsPage(driver);
		addressDetailPage = new coverFoxAddressDetailesPage(driver);
		resultPage = new coverFoxResultPage(driver);

		filePath = System.getProperty("user.dir") + "\\CoverFoxData.properties";
	}

	@BeforeClass
	public void preConditions() throws EncryptedDocumentException, IOException, InterruptedException {
		logger.info("clickOnGenderButton");
		homePage.clickOnGenderButton();
		Thread.sleep(1000);
		logger.info("clickOnNextButton");
		healthPlanPage.clickOnNextButton();
		Thread.sleep(1000);
		logger.warn("age beetween 18 to 75");
		memberDetailPage.handleAgeDropDown(Utility.readDataFromFile(filePath, "age"));
		logger.info("clickOnNextButton");
		memberDetailPage.clickOnNextButton();
		Thread.sleep(1000);
		logger.warn("Enter Right Pin Code");
		addressDetailPage.enterPinCode(Utility.readDataFromFile(filePath, "pincode"));
		logger.warn("Enter Right MobileNumber ");
		addressDetailPage.enterMobileNumber(Utility.readDataFromFile(filePath, "mobileNumber"));
		logger.info("Click On Contineu Button");
		addressDetailPage.clickOnContinue();

	}

	@Test

	public void validateBanners() throws InterruptedException {
		logger.info("validateBanners");
		Thread.sleep(5000);
		int numberFromString = resultPage.getPlanNumberFromString();
		int numberFromBanners = resultPage.getPlanNumberFromBanners();
		Assert.assertEquals(numberFromString, numberFromBanners, "both are not equal");
	}

	@Test
	public void validatePresentOfSortButton() {
		logger.info("validatePresentOfSortButton");
		//Assert.fail();
		boolean displayed = resultPage.sortPlanButtonIsDisplayed();
		Assert.assertTrue(displayed);
	}

	@AfterClass
	public void closeTestCase() {
		logger.info("close browser");
		tearDown();
	}

}
