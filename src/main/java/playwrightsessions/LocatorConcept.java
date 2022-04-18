package playwrightsessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorConcept {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		//locators 
		
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//single element:
//		Locator contactSales = page.locator("text = CONTACT SALES");
//		contactSales.hover();
//		contactSales.click();
		
		//mutliple elements:
//		Locator loginBtn = page.locator("text = Login");
//		int totalLogins = loginBtn.count();//3
//		System.out.println(totalLogins);
//		loginBtn.first().click();
		
		//mutliple elements:
		Locator countryOptions = page.locator("select#Form_submitForm_Country option");
		System.out.println(countryOptions.count());
		
//		for(int i=0; i<countryOptions.count(); i++) {
//			String text = countryOptions.nth(i).textContent();
//			System.out.println(text);
//		}
		
		List<String> optionsTextList = countryOptions.allTextContents();
//		for(String e : optionsTextList) {
//			System.out.println(e);
//		}
		
		optionsTextList.forEach(ele -> System.out.println(ele));
		

	}

}
