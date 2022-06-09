package playwrightsessions;

import java.nio.file.Paths;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TotalAmazonLinks {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
		

		Page page = context.newPage();
		
		page.navigate("https://www.amazon.com/");
		
		List<String> amazonLinksList = page.locator("a:has-text('Amazon')").allInnerTexts();

		amazonLinksList.stream().forEach(e -> System.out.println(e));
		
		context.close();
		browser.close();
		playwright.close();
		
	}

}
