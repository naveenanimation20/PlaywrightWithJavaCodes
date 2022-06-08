package playwrightsessions;

import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFile {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=102.0.5005.27/");

		Download download = page.waitForDownload(() -> {
			page.click("a:text('chromedriver_mac64.zip')");
		});
		//download.cancel(); 
		System.out.println(download.failure());
		
		System.out.println(download.url());
		//System.out.println(download.page().title());

		String path = download.path().toString();
		System.out.println(path);
		
		download.saveAs(Paths.get("Naveen_chrome.zip"));
		System.out.println(download.suggestedFilename());//chromedriver_mac64.zip


	
	
	}

}
