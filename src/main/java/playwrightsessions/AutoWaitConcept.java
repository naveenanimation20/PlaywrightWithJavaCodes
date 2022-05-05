package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutoWaitConcept {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		//text locators 
		Page page = browser.newPage();
		page.navigate("https://www.bigbasket.com/");
		Locator login = page.locator("a:text('Login/Sign') >> nth=1");
		login.click();
		System.out.println(page.locator("button.login-btn:text('Continue')").isEnabled());
		
		page.locator("#otpEmail").fill("9898989898");
		System.out.println(page.locator("button.login-btn:text('Continue')").isEnabled());

		page.locator(".login-icon.login-icon-close").click();
		
	}

}
