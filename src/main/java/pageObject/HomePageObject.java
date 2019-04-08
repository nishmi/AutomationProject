package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.Locators;
import util.SeleniumBase;

public class HomePageObject extends SeleniumBase implements Locators {

	public String validateUser() {
		//Wait for Safari browser
		waitIfSafari();
		//Validate User is logged in
		return driver.findElement(By.xpath(HomePage.User)).getText();
	}

	public void searchText() {
		//Wait for Safari browser
		waitIfSafari();

		driver.findElement(By.id(HomePage.Search)).click();
		//Search for "Writing Tests link"
		driver.findElement(By.id(HomePage.Search)).sendKeys("Writing Tests");
	}

	public String assertWritingTestPage() {
		//Returning the Writing Tests link text to assert Link is displayed
		return driver.findElement(By.xpath(HomePage.SearchListItem)).getText();
	}

	public void navigateToPage() {
		//Wait for Safari browser
		waitIfSafari();

		//Remaining Browsers wait for element to be clickable
		if (!browser.equalsIgnoreCase("safari")) {
			WebDriverWait waits = new WebDriverWait(driver,30);
			waits.until(ExpectedConditions.elementToBeClickable((By.xpath(HomePage.SearchListItem))));
		}

		//Navigate to Writing Tests article page
		driver.findElement(By.xpath(HomePage.SearchListItem)).click();
		waitForPageLoaded(driver);
	}
}
