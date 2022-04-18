package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CommaSelectors {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		//text locators 
		Page page = browser.newPage();
		page.navigate("https://academy.naveenautomationlabs.com");

//		page.locator("span:has-text('SignIn'), "
//				+ "span:has-text('LogIn'), "
//				+ "span:has-text('Login'), "
//				+ "span:has-text('Signin'), "
//				+ "span:has-text('signin')").click();
		
		Locator imp_ele = 
				page.locator("span:has-text('Store'), "
						+ "span:has-text('signin'),"
						+ " a:has-text('EXPLORE COURSES')");
		
		System.out.println(imp_ele.count());
		
		if(imp_ele.count() == 3) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		
		
	}

}
