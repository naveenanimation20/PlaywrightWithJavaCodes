package playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

		page.locator("img[title='vehicle-registration-forms-and-templates']").click();

		page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-8")
				.fill("Naveen Automation");

//		String header = page.frameLocator("//frame[@name='main']").locator("h2").textContent();
//		System.out.println(header);	

//		String h2 = page.frame("main").locator("h2").textContent();
//		System.out.println(h2);

	}

}
