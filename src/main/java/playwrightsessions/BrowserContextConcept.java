package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextConcept {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		LaunchOptions op = new LaunchOptions();
		op.setHeadless(false);
		Browser browser = playwright.chromium().launch(op);
			
		BrowserContext brcx1 = browser.newContext();
		Page p1 = brcx1.newPage();
		p1.setViewportSize(1920, 1080);
		
		p1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
		p1.fill("#Form_submitForm_Name", "Naveen");
		System.out.println(p1.title());
		
		String text = p1.textContent("h1:has-text('Your free trial')");
		System.out.println(text);
		
//		BrowserContext brcx2 = browser.newContext();
//		Page p2 = brcx2.newPage();
//		p2.navigate("http://automationpractice.com/");
//		p2.fill("#search_query_top", "Dress");
//		System.out.println(p2.title());
//		
//		BrowserContext brcx3 = browser.newContext();
//		Page p3 = brcx3.newPage();
//		p3.navigate("http://google.com/");
//		System.out.println(p3.title());
		
//		p1.close();
//		brcx1.close();
//		
//		p2.close();
//		brcx2.close();
//		
//		p3.close();
//		brcx3.close();
//		
		
		
		
		

	}

}
