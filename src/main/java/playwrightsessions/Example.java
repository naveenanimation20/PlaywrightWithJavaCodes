package playwrightsessions;

import java.nio.file.Paths;

import com.microsoft.playwright.*;


public class Example {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      
      context.tracing().start(new Tracing.StartOptions()
    		  .setScreenshots(true)
    		  .setSnapshots(true));

      // Open new page
      Page page = context.newPage();

      // Go to https://academy.naveenautomationlabs.com/
      page.navigate("https://academy.naveenautomationlabs.com/");

      // Click text=Login
      page.click("text=Login");

      page.pause();
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
      page.click("text=+971");

      // Click :nth-match(:text("India (भारत)"), 2)
      page.click(":nth-match(:text(\"India (भारत)\"), 2)");

      // Click [placeholder="Mobile"]
      page.click("[placeholder=\"Mobile\"]");

      // Fill [placeholder="Mobile"]
      page.fill("[placeholder=\"Mobile\"]", "9898989898");

      // Click text=By signing up, I agree to the Terms of Use and Privacy Policy. >> i
      page.click("text=By signing up, I agree to the Terms of Use and Privacy Policy. >> i");

      // Click #loginFormHtml div [aria-label="Close"]
      page.click("#loginFormHtml div [aria-label=\"Close\"]");
      
      context.tracing().stop(new Tracing.StopOptions()
    		  .setPath(Paths.get("trace.zip")));
      
    }
  }
}