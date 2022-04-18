package mytests;

import org.testng.annotations.Test;

import com.microsoft.playwright.*;

public class Demo {

	@Test
	public void test() {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.google.com");
		System.out.println(page.title());
		
		
		
		BrowserContext browserContext1 = browser.newContext();
		Page page1 = browserContext1.newPage();
		page1.navigate("https://www.naveenautomationlabs.com");
		System.out.println(page1.title());
		
		
		
		

	}

}
