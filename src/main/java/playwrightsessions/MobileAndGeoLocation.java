package playwrightsessions;

import static java.util.Arrays.asList;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MobileAndGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		try (Playwright playwright = Playwright.create()) {
//				Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//
//				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//				int width = (int)screenSize.getWidth();
//				int height = (int)screenSize.getHeight();
////
////				
//		      BrowserContext context = browser.newContext(new Browser.NewContextOptions()
//		        .setUserAgent("Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3765.0 Mobile Safari/537.36")
//		        .setViewportSize(width,height)
//		        .setDeviceScaleFactor(2.625)
//		        .setIsMobile(true)
//		        .setHasTouch(true)
//		        .setLocale("en-US")
//		        .setGeolocation(41.889938, 12.492507)
//		        .setPermissions(asList("geolocation")));
//		      Page page = context.newPage();
//		      page.navigate("https://www.openstreetmap.org/");
//		      page.click("a[data-original-title=\"Show My Location\"]");
//		      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("colosseum-pixel2.png")));
		      
			
			//
//			      Browser browser = playwright.webkit().launch();
//			      BrowserContext context = browser.newContext();
//			      Page page = context.newPage();
//			      page.route("**", route -> {
//			        System.out.println(route.request().url());
//			        route.resume();
//			      });
//			      page.navigate("http://amazon.com");
//			    }
			  
		      
		   //
			Browser browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
		      Page page = context.newPage();
		      page.navigate("https://www.amazon.com/");
		      page.evaluate("() => {window.scrollTo(0,document.body.scrollHeight)}");
		      Thread.sleep(10000);
		    }
		      
		      
		}
		  
	}



