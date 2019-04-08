package locators;

public interface Locators {

	//Login Page Locators
	public class LoginPage {
		public static final String UserName = "username";
		public static final String Password = "password";
		public static final String LoginButton = "Login";

	}

	//Home Page Locators
	public class HomePage {
		public static final String HomePageLoginButton = "login-button";
		public static final String User = "//span[contains(.,'NishmiSantosh')]";
		public static final String Search = "st-search-input";
		public static final String SearchListItem = "//p[contains(.,'Writing Tests')]";
		public static final String HomePageLogoutButton = "user-info-logout";

	}

	//Writing Tests Article Page Locators
	public class WritingTestsPage {
		public static final String TestingApexPageLink = "//a[contains(.,'Testing Apex')]";

	}

	//Common Reused Across the Pages Locatos
	public class Common {
		public static final String PageHeading = "topic-title";
		public static final String CookieWindowCloseButton = "dfc-cookie-info-bar-button";
	}
}
