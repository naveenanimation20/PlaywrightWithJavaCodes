package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathUnion {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		// text locators
		Page page = browser.newPage();
		page.navigate("https://academy.naveenautomationlabs.com");

		Locator login = page.locator("//span[text()='signin'] | //span[text()='login']");
		System.out.println(login.textContent());
		login.click();

	}

}
