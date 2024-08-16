package coverFoxPOM;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class coverFoxResultPage {
	// variables

	@FindBy(xpath = "//div[contains(text(),' Insurance Plans')]")
	private WebElement text;
	@FindBy(className = "plan-card-container")
	private List<WebElement> totalBanners;
	@FindBy(xpath = "//div[text()='Sort Plans']")
	private WebElement sortPlanFilter;

	// constructor

	public coverFoxResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// method

	public void banners() {
		String[] ar = text.getText().split(" ");
		int result = Integer.parseInt(ar[0]);

		if (result == totalBanners.size()) {
			System.out.println("TC PASS");
		} else {
			System.out.println("TC FAIL");
		}
	}

	public int getPlanNumberFromString() {
		String[] ar = text.getText().split(" ");
		int result = Integer.parseInt(ar[0]);
		return result;
	}

	public int getPlanNumberFromBanners() {
		int bannerSize = totalBanners.size();
		return bannerSize;
	}

	public boolean sortPlanButtonIsDisplayed() {
		boolean sortDisplayed = sortPlanFilter.isDisplayed();
		return sortDisplayed;

	}

}
