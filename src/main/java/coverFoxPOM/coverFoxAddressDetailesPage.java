package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class coverFoxAddressDetailesPage {

	// variables

	@FindBy(className = "mp-input-text") private WebElement pinCode;
	@FindBy(id = "want-expert")
	private WebElement mobileNumber;
	@FindBy(xpath = "//div[text()='Continue']")
	private WebElement clickContinue;

	// constructor

	public coverFoxAddressDetailesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// method

	public void enterPinCode(String enterPinCode) {
		pinCode.sendKeys(enterPinCode);
	}

	public void enterMobileNumber(String enterMobileNumber) {
		mobileNumber.sendKeys(enterMobileNumber);
	}

	public void clickOnContinue() {
		clickContinue.click();
	}

}
