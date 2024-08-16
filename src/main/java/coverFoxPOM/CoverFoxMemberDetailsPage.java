package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoverFoxMemberDetailsPage {
//webelements
	@FindBy(name = "You") private WebElement AgeDropDown;
	@FindBy(className = "next-btn") private WebElement next_btn;

//constructor
	public CoverFoxMemberDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//method
	public void handleAgeDropDown(String age) {
		Select s = new Select(AgeDropDown);
		s.selectByValue(age+"y");
	}

	public void clickOnNextButton() {
		next_btn.click();
	}

}
