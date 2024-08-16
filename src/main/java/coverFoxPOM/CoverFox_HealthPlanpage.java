package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFox_HealthPlanpage 
{
//data member
@FindBy(className ="next-btn" )	WebElement next_btn;
	
//constructor	
public CoverFox_HealthPlanpage(WebDriver driver) 
{
PageFactory.initElements(driver, this);
}	
	

//method	
public void clickOnNextButton() 
{
	next_btn.click();	
}
	
}
