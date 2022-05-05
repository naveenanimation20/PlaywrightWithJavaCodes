package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ReactElement {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		//React locators 
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.netflix.com/ae-en/");
		
//		Locator email = page.locator("_react=p[name='email'] >> input").first();
//		email.click();
//		email.fill("naveen@gmail.com");
		
		page.locator("_react=UISelect[data-uia='language-picker']").click();
		
		Locator footer = page.locator("_react=UIMarkup[data-uia='data-uia-footer-label']");
		//List<String> footerList = footer.allInnerTexts();

//		for(String e : footerList) {
//			System.out.println(e);
//		}
		footer.allInnerTexts().forEach(e -> System.out.println(e));
	}

}
