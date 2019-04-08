package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.TestingApexPageObject;
import pageObject.WritingTestPageObject;
import util.SeleniumBase;

public class SearchStepDefinition extends SeleniumBase {
	LoginPageObject loginPage = new LoginPageObject();
	HomePageObject homePage = new HomePageObject();
	WritingTestPageObject writingTestsPage = new WritingTestPageObject();
	TestingApexPageObject testingApexPage = new TestingApexPageObject();

	@Before
	public void setUp() {
		//Initialize the browser and navigate to developer.salesforce.com page
		SeleniumBase.initialize();
		//Navigate to Login Page
		loginPage.navigateToLoginPage();
		waitForPageLoaded(driver);
	}

	@After
	public void tearDown() {
		//Log out of the account
		loginPage.logout();
		//Close all browsers
		loginPage.quit();
	}

	@Given("User is on Login Page and enters credentials")
	public void user_is_on_Login_Page_and_enters_credentials() throws InterruptedException {
		//Get the username and password values from config.properties file
		loginPage.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));
	}

	@When("User logs in")
	public void user_logs_in() {
		//Login to the Account
		loginPage.login();
	}

	@Then("User searches for the Writing Tests")
	public void user_searches_for_the_Writing_Tests() {
		//Search for Writing Tests page link in the Search field
		homePage.searchText();
	}

	@Then("List with the link for Writing Tests should be displayed")
	public void list_of_with_the_link_for_Writing_Tests_article_should_be_displayed() {
		//Assert Writing Test page is listed 
		String linkText = homePage.assertWritingTestPage();
		Assert.assertEquals("Writing Tests | Apex Developer Guide | Salesforce Developers", linkText);
	}

	@Then("User should navigate to Writing Tests page")
	public void user_User_should_navigate_to_Writing_Tests_page() {
		//Navigate to Writing Tests article page
		homePage.navigateToPage();
	}

	@And("User finds the Testing Apex link")
	public void user_finds_the_Testing_Apex_link() {
		//Search for Testing Apex link in the Writing Tests page
		writingTestsPage.searchLink();
	}

	@Then("User Navigates to Testing Apex page and verifies page is open")
	public void user_Navigates_to_Testing_Apex_page() {
		//Navigate to Testing Apex article page
		writingTestsPage.navigateToTestApexPage();

		//Assert Testing Apex page is loaded
		String heading = testingApexPage.validatePageOpen();
		Assert.assertEquals("Testing Apex", heading);
	}
}
