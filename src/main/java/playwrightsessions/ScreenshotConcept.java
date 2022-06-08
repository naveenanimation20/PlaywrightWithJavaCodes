package playwrightsessions;


import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.ScreenshotOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScreenshotConcept {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		
		Page page = browser.newPage();
		page.navigate("https://naveenautomationlabs.com/opencart/");
		
		byte b[] = page.screenshot();
		
		page.screenshot
			(new Page.ScreenshotOptions()
						.setPath(Paths.get("screenshotpage.png"))
								.setFullPage(true));
		
		page.screenshot
		(new Page.ScreenshotOptions()
					.setPath(Paths.get("screenshot.png"))
							.setFullPage(false));
		
		
		page.locator("img[title='MacBook']")
			.screenshot(new ScreenshotOptions()
						.setPath(Paths.get("laptop.png")));
		
		page.locator("div#content div.row")
			.screenshot(new ScreenshotOptions()
					.setPath(Paths.get("featured.png")));
		
		
	}

}
