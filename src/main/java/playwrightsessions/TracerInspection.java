package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class TracerInspection {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			
			// Start tracing before creating / navigating a page.
			context.tracing().start(new Tracing.StartOptions()
			  .setScreenshots(true)
			  .setSnapshots(true));

			// Open new page
			Page page = context.newPage();

			// Go to https://academy.naveenautomationlabs.com/
			page.navigate("https://academy.naveenautomationlabs.com/");

			// Click text=Store
			page.click("text=Store");
			// assert page.url().equals("https://academy.naveenautomationlabs.com/s/store");

			// Click text=Login
			page.click("text=Login");

			// Click button:has-text("Sign Up")
			page.click("button:has-text(\"Sign Up\")");

			// Click [placeholder="Name"]
			page.click("[placeholder=\"Name\"]");

			// Fill [placeholder="Name"]
			page.fill("[placeholder=\"Name\"]", "naveen");

			// Press Tab
			page.press("[placeholder=\"Name\"]", "Tab");

			// Fill [placeholder="Email"]
			page.fill("[placeholder=\"Email\"]", "naveen@gmail.com");

			// Press Tab
			page.press("[placeholder=\"Email\"]", "Tab");

			// Fill [placeholder="Create Password"]
			page.fill("[placeholder=\"Create Password\"]", "Test@123");

			// Click text=+971
			page.click("text=+971");

			// Click text=United Arab Emirates (‫الإمارات العربية المتحدة‬‎)
			page.click("text=United Arab Emirates (‫الإمارات العربية المتحدة‬‎)");

			// Fill [placeholder="Mobile"]
			page.fill("[placeholder=\"Mobile\"]", "7876543456");

			// Click text=By signing up, I agree to the Terms of Use and Privacy Policy. >>
			// i
			page.click("text=By signing up, I agree to the Terms of Use and Privacy Policy. >> i");

			// Click #loginFormHtml div [aria-label="Close"]
			page.click("#loginFormHtml div [aria-label=\"Close\"]");

			// Click text=Login
			page.click("text=Login");
			
			
			// Stop tracing and export it into a zip archive.
			context.tracing().stop(new Tracing.StopOptions()
			  .setPath(Paths.get("trace.zip")));
		}
	}
}