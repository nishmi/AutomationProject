package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.Locators.Common;
import locators.Locators.WritingTestsPage;
import util.SeleniumBase;

public class WritingTestPageObject extends SeleniumBase{

	public void searchLink() {
		waitForPageLoaded(driver);

		//Wait when browser is Safari 
		waitIfSafari();

		//Remaining Browsers wait for element to be clickable
		if (!browser.equalsIgnoreCase("safari")) {
			WebDriverWait waits = new WebDriverWait(driver,50);
			waits.until(ExpectedConditions.visibilityOfElementLocated((By.id(Common.PageHeading))));
		}
		//Assert 'Writing Tests' page is open
		String heading = driver.findElement(By.id(Common.PageHeading)).getText();
		Assert.assertEquals("Writing Tests", heading);

		//Close the Cookie Window
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('"+ Common.CookieWindowCloseButton +"').click();");

		//Find the link for 'Testing Apex' page
		String link = driver.findElement(By.xpath(WritingTestsPage.TestingApexPageLink)).getText();

		//Assert Testing Apex page is opened
		Assert.assertEquals("Testing Apex", link);
	}

	public void navigateToTestApexPage() {
		//Navigate to Testing Apex page
		driver.findElement(By.xpath(WritingTestsPage.TestingApexPageLink)).click();
		waitForPageLoaded(driver);
	}

}
