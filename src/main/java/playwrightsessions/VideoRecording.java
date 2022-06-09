package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecording {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext browserContext = browser
							.newContext(new Browser.NewContextOptions()
										.setRecordVideoDir(Paths.get("myvideos/"))
										.setRecordVideoSize(640, 480));

		Page page = browserContext.newPage();

		// Go to https://academy.naveenautomationlabs.com/
		page.navigate("https://academy.naveenautomationlabs.com/");

		// Click text=Login
		page.click("text=Login");

		// Click button:has-text("Sign Up")
		page.click("button:has-text(\"Sign Up\")");

		// Click [placeholder="Name"]
		page.click("[placeholder=\"Name\"]");

		// Fill [placeholder="Name"]
		page.fill("[placeholder=\"Name\"]", "testingautomatiomn");

		// Fill [placeholder="Email"]
		page.fill("[placeholder=\"Email\"]", "testautomation@gmail.com");

		// Fill [placeholder="Create Password"]
		page.fill("[placeholder=\"Create Password\"]", "test123");

		// Click text=+971
		page.click("text=+91");

		// Click :nth-match(:text("India (भारत)"), 2)
		page.click(":nth-match(:text(\"India (भारत)\"), 2)");

		// Click [placeholder="Mobile"]
		page.click("[placeholder=\"Mobile\"]");

		// Fill [placeholder="Mobile"]
		page.fill("[placeholder=\"Mobile\"]", "9898989898");

		// Click text=By signing up, I agree to the Terms of Use and Privacy Policy. >>
		// i
		page.click("text=By signing up, I agree to the Terms of Use and Privacy Policy. >> i");

		// Click #loginFormHtml div [aria-label="Close"]
		page.click("#loginFormHtml div [aria-label=\"Close\"]");
		
		browserContext.close();
		page.close();
		playwright.close();

	}

}
