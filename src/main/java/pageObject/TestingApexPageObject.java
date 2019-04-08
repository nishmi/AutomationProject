package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.Locators;
import util.SeleniumBase;

public class TestingApexPageObject extends SeleniumBase implements Locators {

	public String validatePageOpen() {
		//Wait when browser is Safari 
		waitIfSafari();

		//Remaining Browsers wait for element to be clickable
		if (!browser.equalsIgnoreCase("safari")) {
			WebDriverWait waits = new WebDriverWait(driver,60);
			waits.until(ExpectedConditions.presenceOfElementLocated((By.id(Common.PageHeading))));
		}

		//Return the heading of the Page
		return driver.findElement(By.id(Common.PageHeading)).getText();
	}
}
