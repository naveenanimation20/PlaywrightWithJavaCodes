package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScopeLocators {

	static Page page;
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		page = browser.newPage();
		//page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		
//		Locator row = page.locator("table#example tr");
//		row.locator(":scope", new Locator.LocatorOptions().setHasText("Ashton Cox")).locator(".select-checkbox").click();
//		row.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));
		
		
		page.navigate("https://www.primefaces.org/primeng/table");	
		
		Locator row = page.locator("table#pr_id_2-table tr");
		row.locator(":scope", new Locator.LocatorOptions().setHasText("James Butt")).locator(".p-checkbox-box")
				.click();
		
		row.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));
		
		
		
		
	}

}
