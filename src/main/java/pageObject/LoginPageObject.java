package pageObject;

import org.openqa.selenium.By;

import locators.Locators;
import util.SeleniumBase;

public class LoginPageObject extends SeleniumBase implements Locators {

	public void navigateToLoginPage(){
		//Click on the Home page Login button
		driver.findElement(By.id(HomePage.HomePageLoginButton)).click();
	}

	public void enterCredentials(String username, String password) {
		//Wait when browser is Safari 
		waitIfSafari();

		//Enter the Username and Password
		driver.findElement(By.id(LoginPage.UserName)).sendKeys(username);
		driver.findElement(By.id(LoginPage.Password)).sendKeys(password);
	}

	public void login() {
		//Click on the Login Page Login button
		driver.findElement(By.id(LoginPage.LoginButton)).click();

		waitForPageLoaded(driver);
		//Wait when browser is Safari 
		waitIfSafari();
	}

	public void logout() {
		//Wait when browser is Safari 
		waitIfSafari();
		//Click on the Home page Login button
		driver.findElement(By.id(HomePage.HomePageLoginButton)).click();
		//Click on the Log out button
		driver.findElement(By.id(HomePage.HomePageLogoutButton)).click();
	}

	public void quit() {
		//Close all browsers
		driver.quit();
	}
}
