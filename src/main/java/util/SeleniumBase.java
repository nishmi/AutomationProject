package util;
import static io.github.bonigarcia.wdm.DriverManagerType.EDGE;
import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import static io.github.bonigarcia.wdm.DriverManagerType.IEXPLORER;
import static io.github.bonigarcia.wdm.DriverManagerType.OPERA;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String browser;
	public static String projectDir = System.getProperty("user.dir");

	public SeleniumBase() {
		//Get the config.properties file
		try {
			prop = new Properties();
			FileInputStream fs = new FileInputStream(projectDir+ "/src/main/java/config/config.properties");
			prop.load(fs);
		}
		catch(IOException e) {
			e.getMessage();		
		}
	}

	public static void initialize() {
		//Get the browser name
		String browserName = prop.getProperty("browser");

		//WebDrivers are selected using Maven
		// Initialize WebDriver based on the browser selected
		if (browserName.equals("chrome")) {
			//WebDriverManager.getInstance(CHROME).setup(); // This throws an error due to existing bug in WebDriverManager class works only with version 74.

			//Provide the version of chrome driver
			WebDriverManager.chromedriver().version("73.0.3683.68").setup();
			driver = new ChromeDriver();
		}

		if (browserName.equals("firefox")) {
			WebDriverManager.getInstance(FIREFOX).setup();
			driver = new FirefoxDriver();
		}

		if (browserName.equalsIgnoreCase("opera")) {
			WebDriverManager.getInstance(OPERA).setup();
			driver = new OperaDriver();
		}

		//Find the OS type and run tests according to OS for browser specific OS
		String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);

		if (browserName.equals("ie")) {
			//Check if OS is Windows, if not throw exception
			if (OS.indexOf("win") < 0) {
				throw new UnsupportedOperationException();
			}
			WebDriverManager.getInstance(IEXPLORER).setup();
			driver = new InternetExplorerDriver();
		}

		if (browserName.equalsIgnoreCase("safari")) {
			//Check if OS is Mac, if not throw exception
			if ((OS.indexOf("mac") < 0)) {
				throw new UnsupportedOperationException();
			}
			System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
			driver = new SafariDriver();
		}

		if (browserName.equalsIgnoreCase("edge")) {
			//Check if OS is Windows, if not throw exception
			if (OS.indexOf("win") < 0) {
				throw new UnsupportedOperationException();
			}
			WebDriverManager.getInstance(EDGE).setup();
			driver = new EdgeDriver();
		}

		browser = browserName;
		driver.manage().window().maximize(); //Maximize window
		driver.manage().deleteAllCookies(); // Delete all Cookies
		driver.manage().timeouts().pageLoadTimeout(UtilitySetup.PAGELOAD_TIMEOUT, TimeUnit.SECONDS); //Set Page Timeout
		driver.manage().timeouts().implicitlyWait(UtilitySetup.IMPLICIT_WAIT, TimeUnit.SECONDS); // Set Implicit wait time

		//Get the url from config.properties and Navigate to developer.salesforce.com page
		driver.get(prop.getProperty("url"));
	}

	public static void waitForPageLoaded(WebDriver driver) {
		//Wait for page to load
		Wait<WebDriver> wait = new WebDriverWait(driver, 50);
		ExpectedCondition<Boolean> pageLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		wait.until(pageLoad);
		System.out.println("---Page Loaded---");
	}

	public static void waitIfSafari() {
		//Explicit wait only for Safari
		if (browser.equalsIgnoreCase("safari")) {
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
